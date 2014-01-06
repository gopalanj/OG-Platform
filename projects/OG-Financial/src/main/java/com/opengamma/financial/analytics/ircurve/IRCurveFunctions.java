/**
 * Copyright (C) 2013 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.financial.analytics.ircurve;

import java.util.ArrayList;
import java.util.List;

import com.opengamma.core.change.ChangeEvent;
import com.opengamma.core.change.ChangeManager;
import com.opengamma.core.config.impl.ConfigItem;
import com.opengamma.engine.function.config.AbstractFunctionConfigurationBean;
import com.opengamma.engine.function.config.DynamicFunctionConfigurationBean;
import com.opengamma.engine.function.config.FunctionConfiguration;
import com.opengamma.engine.function.config.FunctionConfigurationSource;
import com.opengamma.engine.function.config.VersionedFunctionConfigurationBean;
import com.opengamma.financial.analytics.BucketedPV01Function;
import com.opengamma.financial.analytics.ISINFunction;
import com.opengamma.financial.analytics.curve.ConstantCurveDefinition;
import com.opengamma.financial.analytics.curve.CurveDefinition;
import com.opengamma.financial.analytics.curve.CurveDefinitionFunction;
import com.opengamma.financial.analytics.curve.CurveMarketDataFunction;
import com.opengamma.financial.analytics.curve.CurveSpecificationFunction;
import com.opengamma.financial.analytics.curve.InterpolatedCurveDefinition;
import com.opengamma.financial.analytics.curve.SpreadCurveDefinition;
import com.opengamma.financial.analytics.ircurve.calcconfig.MultiCurveCalculationConfig;
import com.opengamma.financial.analytics.model.curve.interestrate.ImpliedDepositCurveFunction;
import com.opengamma.financial.analytics.model.curve.interestrate.ImpliedDepositCurveSeriesFunction;
import com.opengamma.master.config.ConfigDocument;
import com.opengamma.master.config.ConfigMaster;
import com.opengamma.master.config.ConfigSearchRequest;
import com.opengamma.master.config.impl.ConfigSearchIterator;

/**
 * Function repository configuration source for the functions contained in this package.
 */
public class IRCurveFunctions extends AbstractFunctionConfigurationBean {

  /**
   * Default instance of a repository configuration source exposing the functions from this package.
   * 
   * @return the configuration source exposing functions from this package
   */
  public static FunctionConfigurationSource instance() {
    return new IRCurveFunctions().getObjectCreating();
  }

  public static FunctionConfigurationSource providers(final ConfigMaster configMaster) {
    return new DynamicFunctionConfigurationBean() {

      @Override
      public ChangeManager getUnderlyingChangeManager() {
        return configMaster.changeManager();
      }

      @Override
      protected VersionedFunctionConfigurationBean createConfiguration() {
        final Providers providers = new Providers();
        providers.setConfigMaster(configMaster);
        return providers;
      }

      @Override
      protected boolean isPropogateEvent(ChangeEvent event) {
        // TODO: Filter the events
        return true;
      }

    };
  }

  /**
   * Function repository configuration source for yield curve functions based on the items defined in a Config Master.
   */
  public static class Providers extends VersionedFunctionConfigurationBean {

    private ConfigMaster _configMaster;

    public void setConfigMaster(final ConfigMaster configMaster) {
      _configMaster = configMaster;
    }

    public ConfigMaster getConfigMaster() {
      return _configMaster;
    }

    protected void addYieldCurveFunctions(final List<FunctionConfiguration> functions, final String currency, final String curveName) {
      functions.add(functionConfiguration(YieldCurveMarketDataFunction.class, currency, curveName));
      functions.add(functionConfiguration(YieldCurveInterpolatingFunction.class, currency, curveName));
      functions.add(functionConfiguration(YieldCurveSpecificationFunction.class, currency, curveName));
    }

    protected void addCurveFunctions(final List<FunctionConfiguration> functions, final String curveName) {
      functions.add(functionConfiguration(CurveDefinitionFunction.class, curveName));
      functions.add(functionConfiguration(CurveSpecificationFunction.class, curveName));
      functions.add(functionConfiguration(CurveMarketDataFunction.class, curveName));
    }

    @Override
    protected void addAllConfigurations(final List<FunctionConfiguration> functions) {

      // implied deposit curves
      final List<String> impliedDepositCurveNames = new ArrayList<>();
      final ConfigSearchRequest<YieldCurveDefinition> searchRequest = new ConfigSearchRequest<>();
      searchRequest.setType(MultiCurveCalculationConfig.class);
      searchRequest.setVersionCorrection(getVersionCorrection());
      for (final ConfigDocument configDocument : ConfigSearchIterator.iterable(_configMaster, searchRequest)) {
        final String documentName = configDocument.getName();
        final MultiCurveCalculationConfig config = ((ConfigItem<MultiCurveCalculationConfig>) configDocument.getConfig()).getValue();
        if (config.getCalculationMethod().equals(ImpliedDepositCurveFunction.IMPLIED_DEPOSIT)) {
          functions.add(functionConfiguration(ImpliedDepositCurveFunction.class, documentName));
          functions.add(functionConfiguration(ImpliedDepositCurveSeriesFunction.class, documentName));
          final String currencyISO = config.getTarget().getUniqueId().getValue();
          final String[] yieldCurveNames = config.getYieldCurveNames();
          for (final String curveName : yieldCurveNames) {
            functions.add(functionConfiguration(ImpliedYieldCurveSpecificationFunction.class, currencyISO, curveName));
            impliedDepositCurveNames.add(curveName);
          }
        }
      }

      searchRequest.setType(YieldCurveDefinition.class);
      searchRequest.setVersionCorrection(getVersionCorrection());
      for (final ConfigDocument configDocument : ConfigSearchIterator.iterable(getConfigMaster(), searchRequest)) {
        final String documentName = configDocument.getName();
        final int underscore = documentName.lastIndexOf('_');
        if (underscore <= 0) {
          continue;
        }
        final String curveName = documentName.substring(0, underscore);
        if (!impliedDepositCurveNames.contains(curveName)) { // don't want to add curves with implied rates to the normal yield curve calculator
          final String currencyISO = documentName.substring(underscore + 1);
          addYieldCurveFunctions(functions, currencyISO, curveName);
        }
      }

      // new curves
      final Class[] curveClasses = new Class[] {CurveDefinition.class, InterpolatedCurveDefinition.class, ConstantCurveDefinition.class, SpreadCurveDefinition.class };
      for (final Class klass : curveClasses) {
        searchRequest.setType(klass);
        searchRequest.setVersionCorrection(getVersionCorrection());
        for (final ConfigDocument configDocument : ConfigSearchIterator.iterable(getConfigMaster(), searchRequest)) {
          final String documentName = configDocument.getName();
          addCurveFunctions(functions, documentName);
        }
      }
    }

  }

  @Override
  protected void addAllConfigurations(final List<FunctionConfiguration> functions) {
    functions.add(functionConfiguration(BucketedPV01Function.class));
    functions.add(functionConfiguration(DefaultYieldCurveMarketDataShiftFunction.class));
    functions.add(functionConfiguration(DefaultYieldCurveShiftFunction.class));
    functions.add(functionConfiguration(ISINFunction.class));
    functions.add(functionConfiguration(YieldCurveMarketDataShiftFunction.class));
    functions.add(functionConfiguration(YieldCurveShiftFunction.class));
  }

}
