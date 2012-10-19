package com.opengamma.masterdb.security.hibernate.future;

import java.util.Map;

import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.masterdb.security.hibernate.CurrencyBean;

/**
 * Copyright (C) 2012 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */

@BeanDefinition
public class ForeignExchangeFutureBean extends FutureSecurityBean {
  @PropertyDefinition
  private CurrencyBean _numerator;
  @PropertyDefinition
  private CurrencyBean _denominator;

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitFXFutureType(this);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code ForeignExchangeFutureBean}.
   * @return the meta-bean, not null
   */
  public static ForeignExchangeFutureBean.Meta meta() {
    return ForeignExchangeFutureBean.Meta.INSTANCE;
  }
  static {
    JodaBeanUtils.registerMetaBean(ForeignExchangeFutureBean.Meta.INSTANCE);
  }

  @Override
  public ForeignExchangeFutureBean.Meta metaBean() {
    return ForeignExchangeFutureBean.Meta.INSTANCE;
  }

  @Override
  protected Object propertyGet(String propertyName, boolean quiet) {
    switch (propertyName.hashCode()) {
      case 1747334793:  // numerator
        return getNumerator();
      case -1983274394:  // denominator
        return getDenominator();
    }
    return super.propertyGet(propertyName, quiet);
  }

  @Override
  protected void propertySet(String propertyName, Object newValue, boolean quiet) {
    switch (propertyName.hashCode()) {
      case 1747334793:  // numerator
        setNumerator((CurrencyBean) newValue);
        return;
      case -1983274394:  // denominator
        setDenominator((CurrencyBean) newValue);
        return;
    }
    super.propertySet(propertyName, newValue, quiet);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      ForeignExchangeFutureBean other = (ForeignExchangeFutureBean) obj;
      return JodaBeanUtils.equal(getNumerator(), other.getNumerator()) &&
          JodaBeanUtils.equal(getDenominator(), other.getDenominator()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash += hash * 31 + JodaBeanUtils.hashCode(getNumerator());
    hash += hash * 31 + JodaBeanUtils.hashCode(getDenominator());
    return hash ^ super.hashCode();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the numerator.
   * @return the value of the property
   */
  public CurrencyBean getNumerator() {
    return _numerator;
  }

  /**
   * Sets the numerator.
   * @param numerator  the new value of the property
   */
  public void setNumerator(CurrencyBean numerator) {
    this._numerator = numerator;
  }

  /**
   * Gets the the {@code numerator} property.
   * @return the property, not null
   */
  public final Property<CurrencyBean> numerator() {
    return metaBean().numerator().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the denominator.
   * @return the value of the property
   */
  public CurrencyBean getDenominator() {
    return _denominator;
  }

  /**
   * Sets the denominator.
   * @param denominator  the new value of the property
   */
  public void setDenominator(CurrencyBean denominator) {
    this._denominator = denominator;
  }

  /**
   * Gets the the {@code denominator} property.
   * @return the property, not null
   */
  public final Property<CurrencyBean> denominator() {
    return metaBean().denominator().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code ForeignExchangeFutureBean}.
   */
  public static class Meta extends FutureSecurityBean.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code numerator} property.
     */
    private final MetaProperty<CurrencyBean> _numerator = DirectMetaProperty.ofReadWrite(
        this, "numerator", ForeignExchangeFutureBean.class, CurrencyBean.class);
    /**
     * The meta-property for the {@code denominator} property.
     */
    private final MetaProperty<CurrencyBean> _denominator = DirectMetaProperty.ofReadWrite(
        this, "denominator", ForeignExchangeFutureBean.class, CurrencyBean.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
      this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "numerator",
        "denominator");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 1747334793:  // numerator
          return _numerator;
        case -1983274394:  // denominator
          return _denominator;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends ForeignExchangeFutureBean> builder() {
      return new DirectBeanBuilder<ForeignExchangeFutureBean>(new ForeignExchangeFutureBean());
    }

    @Override
    public Class<? extends ForeignExchangeFutureBean> beanType() {
      return ForeignExchangeFutureBean.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code numerator} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<CurrencyBean> numerator() {
      return _numerator;
    }

    /**
     * The meta-property for the {@code denominator} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<CurrencyBean> denominator() {
      return _denominator;
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
