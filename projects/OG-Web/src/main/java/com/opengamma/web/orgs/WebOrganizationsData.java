/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.web.orgs;

import java.util.Map;

import javax.ws.rs.core.UriInfo;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBean;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.id.UniqueId;
import com.opengamma.master.orgs.OrganizationDocument;
import com.opengamma.master.orgs.OrganizationMaster;

/**
 * Data class for web-based organizations.
 */
@BeanDefinition
public class WebOrganizationsData extends DirectBean {

  /**
   * The organization master.
   */
  @PropertyDefinition
  private OrganizationMaster _organizationMaster;
  /**
   * The JSR-311 URI information.
   */
  @PropertyDefinition
  private UriInfo _uriInfo;
  /**
   * The organization id from the input URI.
   */
  @PropertyDefinition
  private String _uriOrganizationId;
  /**
   * The version id from the URI.
   */
  @PropertyDefinition
  private String _uriVersionId;
  /**
   * The organization.
   */
  @PropertyDefinition
  private OrganizationDocument _organization;
  /**
   * The versioned organization.
   */
  @PropertyDefinition
  private OrganizationDocument _versioned;

  /**
   * Creates an instance.
   */
  public WebOrganizationsData() {
  }

  /**
   * Creates an instance.
   * @param uriInfo  the URI information
   */
  public WebOrganizationsData(final UriInfo uriInfo) {
    setUriInfo(uriInfo);
  }

  //-------------------------------------------------------------------------
  /**
   * Gets the best available organizations id.
   * @param overrideId  the override id, null derives the result from the data
   * @return the id, may be null
   */
  public String getBestOrganizationUriId(final UniqueId overrideId) {
    if (overrideId != null) {
      return overrideId.toLatest().toString();
    }
    return getOrganization() != null ? getOrganization().getUniqueId().toLatest().toString() : getUriOrganizationId();
  }

  
  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code WebOrganizationsData}.
   * @return the meta-bean, not null
   */
  public static WebOrganizationsData.Meta meta() {
    return WebOrganizationsData.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(WebOrganizationsData.Meta.INSTANCE);
  }

  @Override
  public WebOrganizationsData.Meta metaBean() {
    return WebOrganizationsData.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the organization master.
   * @return the value of the property
   */
  public OrganizationMaster getOrganizationMaster() {
    return _organizationMaster;
  }

  /**
   * Sets the organization master.
   * @param organizationMaster  the new value of the property
   */
  public void setOrganizationMaster(OrganizationMaster organizationMaster) {
    this._organizationMaster = organizationMaster;
  }

  /**
   * Gets the the {@code organizationMaster} property.
   * @return the property, not null
   */
  public final Property<OrganizationMaster> organizationMaster() {
    return metaBean().organizationMaster().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the JSR-311 URI information.
   * @return the value of the property
   */
  public UriInfo getUriInfo() {
    return _uriInfo;
  }

  /**
   * Sets the JSR-311 URI information.
   * @param uriInfo  the new value of the property
   */
  public void setUriInfo(UriInfo uriInfo) {
    this._uriInfo = uriInfo;
  }

  /**
   * Gets the the {@code uriInfo} property.
   * @return the property, not null
   */
  public final Property<UriInfo> uriInfo() {
    return metaBean().uriInfo().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the organization id from the input URI.
   * @return the value of the property
   */
  public String getUriOrganizationId() {
    return _uriOrganizationId;
  }

  /**
   * Sets the organization id from the input URI.
   * @param uriOrganizationId  the new value of the property
   */
  public void setUriOrganizationId(String uriOrganizationId) {
    this._uriOrganizationId = uriOrganizationId;
  }

  /**
   * Gets the the {@code uriOrganizationId} property.
   * @return the property, not null
   */
  public final Property<String> uriOrganizationId() {
    return metaBean().uriOrganizationId().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the version id from the URI.
   * @return the value of the property
   */
  public String getUriVersionId() {
    return _uriVersionId;
  }

  /**
   * Sets the version id from the URI.
   * @param uriVersionId  the new value of the property
   */
  public void setUriVersionId(String uriVersionId) {
    this._uriVersionId = uriVersionId;
  }

  /**
   * Gets the the {@code uriVersionId} property.
   * @return the property, not null
   */
  public final Property<String> uriVersionId() {
    return metaBean().uriVersionId().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the organization.
   * @return the value of the property
   */
  public OrganizationDocument getOrganization() {
    return _organization;
  }

  /**
   * Sets the organization.
   * @param organization  the new value of the property
   */
  public void setOrganization(OrganizationDocument organization) {
    this._organization = organization;
  }

  /**
   * Gets the the {@code organization} property.
   * @return the property, not null
   */
  public final Property<OrganizationDocument> organization() {
    return metaBean().organization().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the versioned organization.
   * @return the value of the property
   */
  public OrganizationDocument getVersioned() {
    return _versioned;
  }

  /**
   * Sets the versioned organization.
   * @param versioned  the new value of the property
   */
  public void setVersioned(OrganizationDocument versioned) {
    this._versioned = versioned;
  }

  /**
   * Gets the the {@code versioned} property.
   * @return the property, not null
   */
  public final Property<OrganizationDocument> versioned() {
    return metaBean().versioned().createProperty(this);
  }

  //-----------------------------------------------------------------------
  @Override
  public WebOrganizationsData clone() {
    BeanBuilder<? extends WebOrganizationsData> builder = metaBean().builder();
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
      WebOrganizationsData other = (WebOrganizationsData) obj;
      return JodaBeanUtils.equal(getOrganizationMaster(), other.getOrganizationMaster()) &&
          JodaBeanUtils.equal(getUriInfo(), other.getUriInfo()) &&
          JodaBeanUtils.equal(getUriOrganizationId(), other.getUriOrganizationId()) &&
          JodaBeanUtils.equal(getUriVersionId(), other.getUriVersionId()) &&
          JodaBeanUtils.equal(getOrganization(), other.getOrganization()) &&
          JodaBeanUtils.equal(getVersioned(), other.getVersioned());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash += hash * 31 + JodaBeanUtils.hashCode(getOrganizationMaster());
    hash += hash * 31 + JodaBeanUtils.hashCode(getUriInfo());
    hash += hash * 31 + JodaBeanUtils.hashCode(getUriOrganizationId());
    hash += hash * 31 + JodaBeanUtils.hashCode(getUriVersionId());
    hash += hash * 31 + JodaBeanUtils.hashCode(getOrganization());
    hash += hash * 31 + JodaBeanUtils.hashCode(getVersioned());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(224);
    buf.append("WebOrganizationsData{");
    int len = buf.length();
    toString(buf);
    if (buf.length() > len) {
      buf.setLength(buf.length() - 2);
    }
    buf.append('}');
    return buf.toString();
  }

  protected void toString(StringBuilder buf) {
    buf.append("organizationMaster").append('=').append(JodaBeanUtils.toString(getOrganizationMaster())).append(',').append(' ');
    buf.append("uriInfo").append('=').append(JodaBeanUtils.toString(getUriInfo())).append(',').append(' ');
    buf.append("uriOrganizationId").append('=').append(JodaBeanUtils.toString(getUriOrganizationId())).append(',').append(' ');
    buf.append("uriVersionId").append('=').append(JodaBeanUtils.toString(getUriVersionId())).append(',').append(' ');
    buf.append("organization").append('=').append(JodaBeanUtils.toString(getOrganization())).append(',').append(' ');
    buf.append("versioned").append('=').append(JodaBeanUtils.toString(getVersioned())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code WebOrganizationsData}.
   */
  public static class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code organizationMaster} property.
     */
    private final MetaProperty<OrganizationMaster> _organizationMaster = DirectMetaProperty.ofReadWrite(
        this, "organizationMaster", WebOrganizationsData.class, OrganizationMaster.class);
    /**
     * The meta-property for the {@code uriInfo} property.
     */
    private final MetaProperty<UriInfo> _uriInfo = DirectMetaProperty.ofReadWrite(
        this, "uriInfo", WebOrganizationsData.class, UriInfo.class);
    /**
     * The meta-property for the {@code uriOrganizationId} property.
     */
    private final MetaProperty<String> _uriOrganizationId = DirectMetaProperty.ofReadWrite(
        this, "uriOrganizationId", WebOrganizationsData.class, String.class);
    /**
     * The meta-property for the {@code uriVersionId} property.
     */
    private final MetaProperty<String> _uriVersionId = DirectMetaProperty.ofReadWrite(
        this, "uriVersionId", WebOrganizationsData.class, String.class);
    /**
     * The meta-property for the {@code organization} property.
     */
    private final MetaProperty<OrganizationDocument> _organization = DirectMetaProperty.ofReadWrite(
        this, "organization", WebOrganizationsData.class, OrganizationDocument.class);
    /**
     * The meta-property for the {@code versioned} property.
     */
    private final MetaProperty<OrganizationDocument> _versioned = DirectMetaProperty.ofReadWrite(
        this, "versioned", WebOrganizationsData.class, OrganizationDocument.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "organizationMaster",
        "uriInfo",
        "uriOrganizationId",
        "uriVersionId",
        "organization",
        "versioned");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -1158737547:  // organizationMaster
          return _organizationMaster;
        case -173275078:  // uriInfo
          return _uriInfo;
        case -1197794758:  // uriOrganizationId
          return _uriOrganizationId;
        case 666567687:  // uriVersionId
          return _uriVersionId;
        case 1178922291:  // organization
          return _organization;
        case -1407102089:  // versioned
          return _versioned;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends WebOrganizationsData> builder() {
      return new DirectBeanBuilder<WebOrganizationsData>(new WebOrganizationsData());
    }

    @Override
    public Class<? extends WebOrganizationsData> beanType() {
      return WebOrganizationsData.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code organizationMaster} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<OrganizationMaster> organizationMaster() {
      return _organizationMaster;
    }

    /**
     * The meta-property for the {@code uriInfo} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<UriInfo> uriInfo() {
      return _uriInfo;
    }

    /**
     * The meta-property for the {@code uriOrganizationId} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<String> uriOrganizationId() {
      return _uriOrganizationId;
    }

    /**
     * The meta-property for the {@code uriVersionId} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<String> uriVersionId() {
      return _uriVersionId;
    }

    /**
     * The meta-property for the {@code organization} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<OrganizationDocument> organization() {
      return _organization;
    }

    /**
     * The meta-property for the {@code versioned} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<OrganizationDocument> versioned() {
      return _versioned;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -1158737547:  // organizationMaster
          return ((WebOrganizationsData) bean).getOrganizationMaster();
        case -173275078:  // uriInfo
          return ((WebOrganizationsData) bean).getUriInfo();
        case -1197794758:  // uriOrganizationId
          return ((WebOrganizationsData) bean).getUriOrganizationId();
        case 666567687:  // uriVersionId
          return ((WebOrganizationsData) bean).getUriVersionId();
        case 1178922291:  // organization
          return ((WebOrganizationsData) bean).getOrganization();
        case -1407102089:  // versioned
          return ((WebOrganizationsData) bean).getVersioned();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -1158737547:  // organizationMaster
          ((WebOrganizationsData) bean).setOrganizationMaster((OrganizationMaster) newValue);
          return;
        case -173275078:  // uriInfo
          ((WebOrganizationsData) bean).setUriInfo((UriInfo) newValue);
          return;
        case -1197794758:  // uriOrganizationId
          ((WebOrganizationsData) bean).setUriOrganizationId((String) newValue);
          return;
        case 666567687:  // uriVersionId
          ((WebOrganizationsData) bean).setUriVersionId((String) newValue);
          return;
        case 1178922291:  // organization
          ((WebOrganizationsData) bean).setOrganization((OrganizationDocument) newValue);
          return;
        case -1407102089:  // versioned
          ((WebOrganizationsData) bean).setVersioned((OrganizationDocument) newValue);
          return;
      }
      super.propertySet(bean, propertyName, newValue, quiet);
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
