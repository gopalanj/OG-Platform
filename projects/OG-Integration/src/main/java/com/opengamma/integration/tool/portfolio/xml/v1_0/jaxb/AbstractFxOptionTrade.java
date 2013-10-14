/**
 * Copyright (C) 2013 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.integration.tool.portfolio.xml.v1_0.jaxb;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.financial.security.option.OptionType;
import com.opengamma.util.money.Currency;

@XmlRootElement
@XmlSeeAlso({FxOptionTrade.class, FxDigitalOptionTrade.class, })
@BeanDefinition
public abstract class AbstractFxOptionTrade extends Trade {

  @XmlElement(name = "optionType", required = true)
  @PropertyDefinition(validate = "notNull")
  private OptionType _optionType;

  @XmlElement(name = "buySell", required = true)
  @PropertyDefinition(validate = "notNull")
  private BuySell _buySell;

  @XmlElement(name = "currencyPair", required = true)
  @PropertyDefinition(validate = "notNull")
  private String _currencyPair;

  @XmlElement(name = "optionCurrency", required = true)
  @PropertyDefinition(validate = "notNull")
  private Currency _optionCurrency;

  @XmlElement(name = "strike", required = true)
  @PropertyDefinition(validate = "notNull")
  private BigDecimal _strike;

  @XmlElement(name = "fxExpiry")
  @PropertyDefinition
  private FxExpiry _fxExpiry;

  @XmlElementWrapper(name = "paymentCalendars")
  @XmlElement(name = "calendar")
  @PropertyDefinition
  private Set<Calendar> _paymentCalendars;

  @Override
  public boolean canBePositionAggregated() {
    return false;
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code AbstractFxOptionTrade}.
   * @return the meta-bean, not null
   */
  public static AbstractFxOptionTrade.Meta meta() {
    return AbstractFxOptionTrade.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(AbstractFxOptionTrade.Meta.INSTANCE);
  }

  @Override
  public AbstractFxOptionTrade.Meta metaBean() {
    return AbstractFxOptionTrade.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the optionType.
   * @return the value of the property, not null
   */
  public OptionType getOptionType() {
    return _optionType;
  }

  /**
   * Sets the optionType.
   * @param optionType  the new value of the property, not null
   */
  public void setOptionType(OptionType optionType) {
    JodaBeanUtils.notNull(optionType, "optionType");
    this._optionType = optionType;
  }

  /**
   * Gets the the {@code optionType} property.
   * @return the property, not null
   */
  public final Property<OptionType> optionType() {
    return metaBean().optionType().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the buySell.
   * @return the value of the property, not null
   */
  public BuySell getBuySell() {
    return _buySell;
  }

  /**
   * Sets the buySell.
   * @param buySell  the new value of the property, not null
   */
  public void setBuySell(BuySell buySell) {
    JodaBeanUtils.notNull(buySell, "buySell");
    this._buySell = buySell;
  }

  /**
   * Gets the the {@code buySell} property.
   * @return the property, not null
   */
  public final Property<BuySell> buySell() {
    return metaBean().buySell().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the currencyPair.
   * @return the value of the property, not null
   */
  public String getCurrencyPair() {
    return _currencyPair;
  }

  /**
   * Sets the currencyPair.
   * @param currencyPair  the new value of the property, not null
   */
  public void setCurrencyPair(String currencyPair) {
    JodaBeanUtils.notNull(currencyPair, "currencyPair");
    this._currencyPair = currencyPair;
  }

  /**
   * Gets the the {@code currencyPair} property.
   * @return the property, not null
   */
  public final Property<String> currencyPair() {
    return metaBean().currencyPair().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the optionCurrency.
   * @return the value of the property, not null
   */
  public Currency getOptionCurrency() {
    return _optionCurrency;
  }

  /**
   * Sets the optionCurrency.
   * @param optionCurrency  the new value of the property, not null
   */
  public void setOptionCurrency(Currency optionCurrency) {
    JodaBeanUtils.notNull(optionCurrency, "optionCurrency");
    this._optionCurrency = optionCurrency;
  }

  /**
   * Gets the the {@code optionCurrency} property.
   * @return the property, not null
   */
  public final Property<Currency> optionCurrency() {
    return metaBean().optionCurrency().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the strike.
   * @return the value of the property, not null
   */
  public BigDecimal getStrike() {
    return _strike;
  }

  /**
   * Sets the strike.
   * @param strike  the new value of the property, not null
   */
  public void setStrike(BigDecimal strike) {
    JodaBeanUtils.notNull(strike, "strike");
    this._strike = strike;
  }

  /**
   * Gets the the {@code strike} property.
   * @return the property, not null
   */
  public final Property<BigDecimal> strike() {
    return metaBean().strike().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the fxExpiry.
   * @return the value of the property
   */
  public FxExpiry getFxExpiry() {
    return _fxExpiry;
  }

  /**
   * Sets the fxExpiry.
   * @param fxExpiry  the new value of the property
   */
  public void setFxExpiry(FxExpiry fxExpiry) {
    this._fxExpiry = fxExpiry;
  }

  /**
   * Gets the the {@code fxExpiry} property.
   * @return the property, not null
   */
  public final Property<FxExpiry> fxExpiry() {
    return metaBean().fxExpiry().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the paymentCalendars.
   * @return the value of the property
   */
  public Set<Calendar> getPaymentCalendars() {
    return _paymentCalendars;
  }

  /**
   * Sets the paymentCalendars.
   * @param paymentCalendars  the new value of the property
   */
  public void setPaymentCalendars(Set<Calendar> paymentCalendars) {
    this._paymentCalendars = paymentCalendars;
  }

  /**
   * Gets the the {@code paymentCalendars} property.
   * @return the property, not null
   */
  public final Property<Set<Calendar>> paymentCalendars() {
    return metaBean().paymentCalendars().createProperty(this);
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      AbstractFxOptionTrade other = (AbstractFxOptionTrade) obj;
      return JodaBeanUtils.equal(getOptionType(), other.getOptionType()) &&
          JodaBeanUtils.equal(getBuySell(), other.getBuySell()) &&
          JodaBeanUtils.equal(getCurrencyPair(), other.getCurrencyPair()) &&
          JodaBeanUtils.equal(getOptionCurrency(), other.getOptionCurrency()) &&
          JodaBeanUtils.equal(getStrike(), other.getStrike()) &&
          JodaBeanUtils.equal(getFxExpiry(), other.getFxExpiry()) &&
          JodaBeanUtils.equal(getPaymentCalendars(), other.getPaymentCalendars()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash += hash * 31 + JodaBeanUtils.hashCode(getOptionType());
    hash += hash * 31 + JodaBeanUtils.hashCode(getBuySell());
    hash += hash * 31 + JodaBeanUtils.hashCode(getCurrencyPair());
    hash += hash * 31 + JodaBeanUtils.hashCode(getOptionCurrency());
    hash += hash * 31 + JodaBeanUtils.hashCode(getStrike());
    hash += hash * 31 + JodaBeanUtils.hashCode(getFxExpiry());
    hash += hash * 31 + JodaBeanUtils.hashCode(getPaymentCalendars());
    return hash ^ super.hashCode();
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(256);
    buf.append("AbstractFxOptionTrade{");
    int len = buf.length();
    toString(buf);
    if (buf.length() > len) {
      buf.setLength(buf.length() - 2);
    }
    buf.append('}');
    return buf.toString();
  }

  @Override
  protected void toString(StringBuilder buf) {
    super.toString(buf);
    buf.append("optionType").append('=').append(JodaBeanUtils.toString(getOptionType())).append(',').append(' ');
    buf.append("buySell").append('=').append(JodaBeanUtils.toString(getBuySell())).append(',').append(' ');
    buf.append("currencyPair").append('=').append(JodaBeanUtils.toString(getCurrencyPair())).append(',').append(' ');
    buf.append("optionCurrency").append('=').append(JodaBeanUtils.toString(getOptionCurrency())).append(',').append(' ');
    buf.append("strike").append('=').append(JodaBeanUtils.toString(getStrike())).append(',').append(' ');
    buf.append("fxExpiry").append('=').append(JodaBeanUtils.toString(getFxExpiry())).append(',').append(' ');
    buf.append("paymentCalendars").append('=').append(JodaBeanUtils.toString(getPaymentCalendars())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code AbstractFxOptionTrade}.
   */
  public static class Meta extends Trade.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code optionType} property.
     */
    private final MetaProperty<OptionType> _optionType = DirectMetaProperty.ofReadWrite(
        this, "optionType", AbstractFxOptionTrade.class, OptionType.class);
    /**
     * The meta-property for the {@code buySell} property.
     */
    private final MetaProperty<BuySell> _buySell = DirectMetaProperty.ofReadWrite(
        this, "buySell", AbstractFxOptionTrade.class, BuySell.class);
    /**
     * The meta-property for the {@code currencyPair} property.
     */
    private final MetaProperty<String> _currencyPair = DirectMetaProperty.ofReadWrite(
        this, "currencyPair", AbstractFxOptionTrade.class, String.class);
    /**
     * The meta-property for the {@code optionCurrency} property.
     */
    private final MetaProperty<Currency> _optionCurrency = DirectMetaProperty.ofReadWrite(
        this, "optionCurrency", AbstractFxOptionTrade.class, Currency.class);
    /**
     * The meta-property for the {@code strike} property.
     */
    private final MetaProperty<BigDecimal> _strike = DirectMetaProperty.ofReadWrite(
        this, "strike", AbstractFxOptionTrade.class, BigDecimal.class);
    /**
     * The meta-property for the {@code fxExpiry} property.
     */
    private final MetaProperty<FxExpiry> _fxExpiry = DirectMetaProperty.ofReadWrite(
        this, "fxExpiry", AbstractFxOptionTrade.class, FxExpiry.class);
    /**
     * The meta-property for the {@code paymentCalendars} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<Set<Calendar>> _paymentCalendars = DirectMetaProperty.ofReadWrite(
        this, "paymentCalendars", AbstractFxOptionTrade.class, (Class) Set.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "optionType",
        "buySell",
        "currencyPair",
        "optionCurrency",
        "strike",
        "fxExpiry",
        "paymentCalendars");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 1373587791:  // optionType
          return _optionType;
        case 244977400:  // buySell
          return _buySell;
        case 1005147787:  // currencyPair
          return _currencyPair;
        case -1641048154:  // optionCurrency
          return _optionCurrency;
        case -891985998:  // strike
          return _strike;
        case -1406037851:  // fxExpiry
          return _fxExpiry;
        case -299417201:  // paymentCalendars
          return _paymentCalendars;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends AbstractFxOptionTrade> builder() {
      throw new UnsupportedOperationException("AbstractFxOptionTrade is an abstract class");
    }

    @Override
    public Class<? extends AbstractFxOptionTrade> beanType() {
      return AbstractFxOptionTrade.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code optionType} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<OptionType> optionType() {
      return _optionType;
    }

    /**
     * The meta-property for the {@code buySell} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<BuySell> buySell() {
      return _buySell;
    }

    /**
     * The meta-property for the {@code currencyPair} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<String> currencyPair() {
      return _currencyPair;
    }

    /**
     * The meta-property for the {@code optionCurrency} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Currency> optionCurrency() {
      return _optionCurrency;
    }

    /**
     * The meta-property for the {@code strike} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<BigDecimal> strike() {
      return _strike;
    }

    /**
     * The meta-property for the {@code fxExpiry} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<FxExpiry> fxExpiry() {
      return _fxExpiry;
    }

    /**
     * The meta-property for the {@code paymentCalendars} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Set<Calendar>> paymentCalendars() {
      return _paymentCalendars;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 1373587791:  // optionType
          return ((AbstractFxOptionTrade) bean).getOptionType();
        case 244977400:  // buySell
          return ((AbstractFxOptionTrade) bean).getBuySell();
        case 1005147787:  // currencyPair
          return ((AbstractFxOptionTrade) bean).getCurrencyPair();
        case -1641048154:  // optionCurrency
          return ((AbstractFxOptionTrade) bean).getOptionCurrency();
        case -891985998:  // strike
          return ((AbstractFxOptionTrade) bean).getStrike();
        case -1406037851:  // fxExpiry
          return ((AbstractFxOptionTrade) bean).getFxExpiry();
        case -299417201:  // paymentCalendars
          return ((AbstractFxOptionTrade) bean).getPaymentCalendars();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 1373587791:  // optionType
          ((AbstractFxOptionTrade) bean).setOptionType((OptionType) newValue);
          return;
        case 244977400:  // buySell
          ((AbstractFxOptionTrade) bean).setBuySell((BuySell) newValue);
          return;
        case 1005147787:  // currencyPair
          ((AbstractFxOptionTrade) bean).setCurrencyPair((String) newValue);
          return;
        case -1641048154:  // optionCurrency
          ((AbstractFxOptionTrade) bean).setOptionCurrency((Currency) newValue);
          return;
        case -891985998:  // strike
          ((AbstractFxOptionTrade) bean).setStrike((BigDecimal) newValue);
          return;
        case -1406037851:  // fxExpiry
          ((AbstractFxOptionTrade) bean).setFxExpiry((FxExpiry) newValue);
          return;
        case -299417201:  // paymentCalendars
          ((AbstractFxOptionTrade) bean).setPaymentCalendars((Set<Calendar>) newValue);
          return;
      }
      super.propertySet(bean, propertyName, newValue, quiet);
    }

    @Override
    protected void validate(Bean bean) {
      JodaBeanUtils.notNull(((AbstractFxOptionTrade) bean)._optionType, "optionType");
      JodaBeanUtils.notNull(((AbstractFxOptionTrade) bean)._buySell, "buySell");
      JodaBeanUtils.notNull(((AbstractFxOptionTrade) bean)._currencyPair, "currencyPair");
      JodaBeanUtils.notNull(((AbstractFxOptionTrade) bean)._optionCurrency, "optionCurrency");
      JodaBeanUtils.notNull(((AbstractFxOptionTrade) bean)._strike, "strike");
      super.validate(bean);
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
