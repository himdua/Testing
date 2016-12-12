/*
 * JBILLING CONFIDENTIAL
 * _____________________
 *
 * [2003] - [2012] Enterprise jBilling Software Ltd.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Enterprise jBilling Software.
 * The intellectual and technical concepts contained
 * herein are proprietary to Enterprise jBilling Software
 * and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden.
 */
package com.sapienter.jbilling.server.user.db;


import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sapienter.jbilling.server.metafields.EntityType;
import com.sapienter.jbilling.server.metafields.MetaFieldHelper;
import com.sapienter.jbilling.server.metafields.db.CustomizedEntity;
import com.sapienter.jbilling.server.metafields.db.MetaFieldValue;
import com.sapienter.jbilling.server.report.db.ReportDTO;
import org.hibernate.annotations.*;

import com.sapienter.jbilling.server.invoice.db.InvoiceDeliveryMethodDTO;
import com.sapienter.jbilling.server.item.db.ItemDTO;
import com.sapienter.jbilling.server.item.db.ItemTypeDTO;
import com.sapienter.jbilling.server.notification.db.NotificationMessageDTO;
import com.sapienter.jbilling.server.order.db.OrderPeriodDTO;
import com.sapienter.jbilling.server.process.db.AgeingEntityStepDTO;
import com.sapienter.jbilling.server.process.db.BillingProcessConfigurationDTO;
import com.sapienter.jbilling.server.process.db.BillingProcessDTO;
import com.sapienter.jbilling.server.util.audit.db.EventLogDTO;
import com.sapienter.jbilling.server.util.db.CurrencyDTO;
import com.sapienter.jbilling.server.util.db.LanguageDTO;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.OrderBy;

@Entity
@Table(name = "entity")
@TableGenerator(
    name = "entity_GEN",
    table = "jbilling_seqs",
    pkColumnName = "name",
    valueColumnName = "next_id",
    pkColumnValue = "entity",
    allocationSize = 10
)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CompanyDTO extends CustomizedEntity implements java.io.Serializable {


    private int id;
    private CurrencyDTO currencyDTO;
    private LanguageDTO language;
    private String externalId;
    private String description;
    private Date createDatetime;
    private boolean invoiceAsReseller = false;
    private CompanyDTO parent;
    private UserDTO reseller;
    private Set<AgeingEntityStepDTO> ageingEntitySteps = new HashSet<AgeingEntityStepDTO>(0);
    private Set<OrderPeriodDTO> orderPeriodDTOs = new HashSet<OrderPeriodDTO>(0);
    private Set<BillingProcessDTO> billingProcesses = new HashSet<BillingProcessDTO>(0);
    private Set<UserDTO> baseUsers = new HashSet<UserDTO>(0);
    private Set<ItemDTO> items = new HashSet<ItemDTO>(0);
    private Set<EventLogDTO> eventLogs = new HashSet<EventLogDTO>(0);
    private Set<NotificationMessageDTO> notificationMessages = new HashSet<NotificationMessageDTO>(0);
    private Set<CurrencyDTO> currencyDTOs = new HashSet<CurrencyDTO>(0);
    private Set<ItemTypeDTO> itemTypes = new HashSet<ItemTypeDTO>(0);
    private Set<BillingProcessConfigurationDTO> billingProcessConfigurations = new HashSet<BillingProcessConfigurationDTO>(0);
    private Set<InvoiceDeliveryMethodDTO> invoiceDeliveryMethods = new HashSet<InvoiceDeliveryMethodDTO>(0);
    private Set<ReportDTO> reports = new HashSet<ReportDTO>();
    private List<MetaFieldValue> metaFields = new LinkedList<MetaFieldValue>();
    private int versionNum;
    private Integer deleted;
    private String customerInformationDesign;
    private Integer uiColor;
    private String brokerCatalogVersion;
    private CompanyType type;


    public CompanyDTO() {
    }

    public CompanyDTO(int i) {
        id = i;
    }

    public CompanyDTO(int id, CurrencyDTO currencyDTO, LanguageDTO language, String description, Date createDatetime) {
        this.id = id;
        this.currencyDTO = currencyDTO;
        this.language = language;
        this.description = description;
        this.createDatetime = createDatetime;
    }

    public CompanyDTO(int id, CurrencyDTO currencyDTO, LanguageDTO language, String externalId, String description,
                      Date createDatetime, Set<AgeingEntityStepDTO> ageingEntitySteps,
                      Set<OrderPeriodDTO> orderPeriodDTOs,
                      Set<BillingProcessDTO> billingProcesses, Set<UserDTO> baseUsers,
                      Set<ItemDTO> items, Set<EventLogDTO> eventLogs, Set<NotificationMessageDTO> notificationMessages,
                      Set<CurrencyDTO> currencyDTOs,
                      Set<ItemTypeDTO> itemTypes, Set<BillingProcessConfigurationDTO> billingProcessConfigurations,
                      Set<InvoiceDeliveryMethodDTO> invoiceDeliveryMethods) {
        this.id = id;
        this.currencyDTO = currencyDTO;
        this.language = language;
        this.externalId = externalId;
        this.description = description;
        this.createDatetime = createDatetime;
        this.ageingEntitySteps = ageingEntitySteps;
        this.orderPeriodDTOs = orderPeriodDTOs;
        this.billingProcesses = billingProcesses;
        this.baseUsers = baseUsers;
        this.items = items;
        this.eventLogs = eventLogs;
        this.notificationMessages = notificationMessages;
        this.currencyDTOs = currencyDTOs;
        this.itemTypes = itemTypes;
        this.billingProcessConfigurations = billingProcessConfigurations;
        this.invoiceDeliveryMethods = invoiceDeliveryMethods;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "entity_GEN")
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id", nullable = false)
    public CurrencyDTO getCurrency() {
        return this.currencyDTO;
    }

    public void setCurrency(CurrencyDTO currencyDTO) {
        this.currencyDTO = currencyDTO;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", nullable = false)
    public LanguageDTO getLanguage() {
        return this.language;
    }

    public void setLanguage(LanguageDTO language) {
        this.language = language;
    }

    @Column(name = "external_id", length = 20)
    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @Column(name = "description", nullable = false, length = 100)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "create_datetime", nullable = false, length = 29)
    public Date getCreateDatetime() {
        return this.createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }
    
    @Column(name = "invoice_as_reseller", nullable = true)
    public boolean isInvoiceAsReseller() {
        return invoiceAsReseller;
    }

    public void setInvoiceAsReseller(boolean invoiceAsReseller) {
        this.invoiceAsReseller = invoiceAsReseller;
    }
  
    @OneToOne(fetch = FetchType.LAZY, optional=true)
    @JoinTable(name="reseller_entityid_map",
      joinColumns = {
        @JoinColumn(name="entity_id", referencedColumnName = "id", unique = true)           
      },
      inverseJoinColumns = {
        @JoinColumn(name="user_id", referencedColumnName = "id", unique = true)
      }     
    )
    public UserDTO getReseller(){
    	return reseller;
    }
    
    public void setReseller(UserDTO reseller){
    	this.reseller = reseller;
    }
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "parent_id")
    public CompanyDTO getParent(){
        return this.parent;
    }

    public void setParent(CompanyDTO parent){
        this.parent = parent;
    }
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
    @OrderBy(
            clause = "status_id"
    )
    public Set<AgeingEntityStepDTO> getAgeingEntitySteps() {
        return this.ageingEntitySteps;
    }

    public void setAgeingEntitySteps(Set<AgeingEntityStepDTO> ageingEntitySteps) {
        this.ageingEntitySteps = ageingEntitySteps;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
    public Set<OrderPeriodDTO> getOrderPeriods() {
        return this.orderPeriodDTOs;
    }

    public void setOrderPeriods(Set<OrderPeriodDTO> orderPeriodDTOs) {
        this.orderPeriodDTOs = orderPeriodDTOs;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "entity")
    public Set<BillingProcessDTO> getBillingProcesses() {
        return this.billingProcesses;
    }

    public void setBillingProcesses(Set<BillingProcessDTO> billingProcesses) {
        this.billingProcesses = billingProcesses;
    }

    /**
     * Never use this method. It will run out of memory. Instead use UserDAS().findByEntityId
     *
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    @LazyCollection(value = LazyCollectionOption.EXTRA)
    @BatchSize(size = 100)
    public Set<UserDTO> getBaseUsers() {
        return this.baseUsers;
    }

    public void setBaseUsers(Set<UserDTO> baseUsers) {
        this.baseUsers = baseUsers;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "item_entity_map", joinColumns = {
            @JoinColumn(name = "entity_id", referencedColumnName = "id", updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "item_id", referencedColumnName = "id", updatable = false)
    })
    public Set<ItemDTO> getItems() {
        return this.items;
    }

    public void setItems(Set<ItemDTO> items) {
        this.items = items;
    }
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
    public Set<EventLogDTO> getEventLogs() {
        return this.eventLogs;
    }

    public void setEventLogs(Set<EventLogDTO> eventLogs) {
        this.eventLogs = eventLogs;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "entity")
    public Set<NotificationMessageDTO> getNotificationMessages() {
        return this.notificationMessages;
    }

    public void setNotificationMessages(Set<NotificationMessageDTO> notificationMessages) {
        this.notificationMessages = notificationMessages;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "currency_entity_map", joinColumns = {
            @JoinColumn(name = "entity_id", updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "currency_id", updatable = false)
    })
    public Set<CurrencyDTO> getCurrencies() {
        return this.currencyDTOs;
    }

    public void setCurrencies(Set<CurrencyDTO> currencyDTOs) {
        this.currencyDTOs = currencyDTOs;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "item_type_entity_map", joinColumns = {
            @JoinColumn(name = "entity_id", updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "item_type_id", updatable = false)
    })
    public Set<ItemTypeDTO> getItemTypes() {
        return this.itemTypes;
    }

    public void setItemTypes(Set<ItemTypeDTO> itemTypes) {
        this.itemTypes = itemTypes;
    }
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "entity")
    public Set<BillingProcessConfigurationDTO> getBillingProcessConfigurations() {
        return this.billingProcessConfigurations;
    }

    public void setBillingProcessConfigurations(Set<BillingProcessConfigurationDTO> billingProcessConfigurations) {
        this.billingProcessConfigurations = billingProcessConfigurations;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "entity_delivery_method_map", joinColumns = {
            @JoinColumn(name = "entity_id", updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "method_id", updatable = false)
    })
    public Set<InvoiceDeliveryMethodDTO> getInvoiceDeliveryMethods() {
        return this.invoiceDeliveryMethods;
    }

    public void setInvoiceDeliveryMethods(Set<InvoiceDeliveryMethodDTO> invoiceDeliveryMethods) {
        this.invoiceDeliveryMethods = invoiceDeliveryMethods;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "entity_report_map",
           joinColumns = {
                   @JoinColumn(name = "entity_id", updatable = false)
           },
           inverseJoinColumns = {
                   @JoinColumn(name = "report_id", updatable = false)
           }
    )
    public Set<ReportDTO> getReports() {
        return reports;
    }

    public void setReports(Set<ReportDTO> reports) {
        this.reports = reports;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    @JoinTable(
            name = "entity_meta_field_map",
            joinColumns = @JoinColumn(name = "entity_id"),
            inverseJoinColumns = @JoinColumn(name = "meta_field_value_id")
    )
    @Sort(type = SortType.COMPARATOR, comparator = MetaFieldHelper.MetaFieldValuesOrderComparator.class)
    public List<MetaFieldValue> getMetaFields() {
        return metaFields;
    }

    public void setMetaFields(List<MetaFieldValue> metaFields) {
        this.metaFields = metaFields;
    }

    @Transient
    public EntityType[] getCustomizedEntityType() {
        return new EntityType[] { EntityType.COMPANY };
    }

    /*
    * Conveniant methods to ease migration from entity beans
    */
    @Transient
    public Integer getCurrencyId() {
        return currencyDTO.getId();
    }

    @Transient
    public Integer getLanguageId() {
        if (language == null) {
            language = new CompanyDAS().find(getId()).getLanguage();
        }
        return language.getId();
    }

    @Version
    @Column(name = "OPTLOCK")
    public Integer getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(Integer versionNum) {
        this.versionNum = versionNum;
    }

    public String getAuditKey(Serializable id) {
        StringBuilder key = new StringBuilder();
        key.append(id);

        return key.toString();
    }

    @Column(name = "deleted", nullable = false)
    public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

    @Column(name = "customer_information_design", nullable = true)
    public String getCustomerInformationDesign() {
        return customerInformationDesign;
    }

    public void setCustomerInformationDesign(String customerInformationDesign) {
        this.customerInformationDesign = customerInformationDesign;
    }

    @Column(name = "ui_color", nullable = true)
    public Integer getUiColor() {
        return uiColor;
    }

    public void setUiColor(Integer uiColor) {
        this.uiColor = uiColor;
    }

    @Column(name = "broker_catalog_version", nullable = true)
    public String getBrokerCatalogVersion() {
        return brokerCatalogVersion;
    }

    public void setBrokerCatalogVersion(String brokerCatalogVersion) {
        this.brokerCatalogVersion = brokerCatalogVersion;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = true)
    public CompanyType getType() {
        return type;
    }

    public void setType(CompanyType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return " CompanyDTO: " + id;
    }
}
