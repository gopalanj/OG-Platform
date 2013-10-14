/**
 * Copyright (C) 2013 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.engine.marketdata.spec;

import java.util.Map;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

/**
 * 
 */
@BeanDefinition
public class HistoricalMarketDataSpecification implements Bean, MarketDataSpecification {
  
  private static final long serialVersionUID = 1L;
  /**
   * The timeseries resolver key
   */
  @PropertyDefinition(validate = "notNull")
  private String _timeSeriesResolverKey;
  
  /**
   * Constructor for builders
   */
  public HistoricalMarketDataSpecification() {
  }
  
  /**
   * Creates an instance
   * 
   * @param timeSeriesResolverKey the timeseries resolver key, not null
   */
  public HistoricalMarketDataSpecification(String timeSeriesResolverKey) {
    setTimeSeriesResolverKey(timeSeriesResolverKey);
  }
  
  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code HistoricalMarketDataSpecification}.
   * @return the meta-bean, not null
   */
  public static HistoricalMarketDataSpecification.Meta meta() {
    return HistoricalMarketDataSpecification.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(HistoricalMarketDataSpecification.Meta.INSTANCE);
  }

  @Override
  public HistoricalMarketDataSpecification.Meta metaBean() {
    return HistoricalMarketDataSpecification.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the timeseries resolver key
   * @return the value of the property, not null
   */
  public String getTimeSeriesResolverKey() {
    return _timeSeriesResolverKey;
  }

  /**
   * Sets the timeseries resolver key
   * @param timeSeriesResolverKey  the new value of the property, not null
   */
  public void setTimeSeriesResolverKey(String timeSeriesResolverKey) {
    JodaBeanUtils.notNull(timeSeriesResolverKey, "timeSeriesResolverKey");
    this._timeSeriesResolverKey = timeSeriesResolverKey;
  }

  /**
   * Gets the the {@code timeSeriesResolverKey} property.
   * @return the property, not null
   */
  public final Property<String> timeSeriesResolverKey() {
    return metaBean().timeSeriesResolverKey().createProperty(this);
  }

  //-----------------------------------------------------------------------
  @Override
  public HistoricalMarketDataSpecification clone() {
    BeanBuilder<? extends HistoricalMarketDataSpecification> builder = metaBean().builder();
    for (MetaProperty<?> mp : metaBean().metaPropertyIterable()) {
      if (mp.style().isBuildable()) {
        Object value = mp.get(this);
        if (value instanceof Bean) {
          value = ((Bean) value).clone();
        }
        builder.set(mp.name(), value);
      }
    }
    return builder.build();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      HistoricalMarketDataSpecification other = (HistoricalMarketDataSpecification) obj;
      return JodaBeanUtils.equal(getTimeSeriesResolverKey(), other.getTimeSeriesResolverKey());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash += hash * 31 + JodaBeanUtils.hashCode(getTimeSeriesResolverKey());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(64);
    buf.append("HistoricalMarketDataSpecification{");
    int len = buf.length();
    toString(buf);
    if (buf.length() > len) {
      buf.setLength(buf.length() - 2);
    }
    buf.append('}');
    return buf.toString();
  }

  protected void toString(StringBuilder buf) {
    buf.append("timeSeriesResolverKey").append('=').append(JodaBeanUtils.toString(getTimeSeriesResolverKey())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code HistoricalMarketDataSpecification}.
   */
  public static class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code timeSeriesResolverKey} property.
     */
    private final MetaProperty<String> _timeSeriesResolverKey = DirectMetaProperty.ofReadWrite(
        this, "timeSeriesResolverKey", HistoricalMarketDataSpecification.class, String.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "timeSeriesResolverKey");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 158445109:  // timeSeriesResolverKey
          return _timeSeriesResolverKey;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends HistoricalMarketDataSpecification> builder() {
      return new DirectBeanBuilder<HistoricalMarketDataSpecification>(new HistoricalMarketDataSpecification());
    }

    @Override
    public Class<? extends HistoricalMarketDataSpecification> beanType() {
      return HistoricalMarketDataSpecification.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code timeSeriesResolverKey} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<String> timeSeriesResolverKey() {
      return _timeSeriesResolverKey;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 158445109:  // timeSeriesResolverKey
          return ((HistoricalMarketDataSpecification) bean).getTimeSeriesResolverKey();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 158445109:  // timeSeriesResolverKey
          ((HistoricalMarketDataSpecification) bean).setTimeSeriesResolverKey((String) newValue);
          return;
      }
      super.propertySet(bean, propertyName, newValue, quiet);
    }

    @Override
    protected void validate(Bean bean) {
      JodaBeanUtils.notNull(((HistoricalMarketDataSpecification) bean)._timeSeriesResolverKey, "timeSeriesResolverKey");
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
