/*
 jBilling - The Enterprise Open Source Billing System
 Copyright (C) 2003-2011 Enterprise jBilling Software Ltd. and Emiliano Conde

 This file is part of jbilling.

 jbilling is free software: you can redistribute it and/or modify
 it under the terms of the GNU Affero General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 jbilling is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License
 along with jbilling.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.sapienter.jbilling.server.metafields.db;

import com.sapienter.jbilling.server.metafields.DataType;
import com.sapienter.jbilling.server.metafields.EntityType;
import com.sapienter.jbilling.server.metafields.MetaFieldBL;
import com.sapienter.jbilling.server.metafields.MetaFieldType;
import com.sapienter.jbilling.server.util.Constants;
import com.sapienter.jbilling.server.util.db.AbstractDescription;
import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

/**
 * A meta-field name that is associated with a particular entity type. The field names define
 * the allowed values and data-types of the values that can be attached to an entity.
 *
 * @author Brian Cowdery
 * @since 03-Oct-2011
 */
@Entity
@Table(name = "meta_field_name")
@TableGenerator(
        name = "meta_field_GEN",
        table = "jbilling_seqs",
        pkColumnName = "name",
        valueColumnName = "next_id",
        pkColumnValue = "meta_field_name",
        allocationSize = 1
)
public class MetaField  extends AbstractDescription  implements Serializable {

    private static final long serialVersionUID = 8802138744319569281L;
    private int id;
    private Integer entityId;
    private String name;
    private EntityType entityType;
    private DataType dataType;

    private boolean disabled = false;
    private boolean mandatory = false;

    private Integer displayOrder = 1;
    private MetaFieldValue defaultValue = null;


    private Integer dataTableId;
    private Set<MetaField> dependentMetaFields = new HashSet<MetaField>();
    private String helpDescription;
    private String helpContentURL;


    private ValidationRule validationRule;

    //indicate whether the metafield is a primary field and can be used for creation of metafield groups and for providing
    //    a meta-fields to be populated for the entity type they belong to
    //Metafields created from the Configuration - MetaField menu will be considered as primary metafields by default. 
    //All other dynamic metafields created on the fly in the system (example: Account Information Type, Product Category) will not be considered as primary
    private Boolean primary;

    private MetaFieldType fieldUsage;

    private Set<MetaFieldGroup> metaFieldGroups;

    private Integer versionNum;

    private String filename;

    public MetaField() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "meta_field_GEN")
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "entity_id")
    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "entity_type", nullable = false, length = 25)
    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "data_type", nullable = false, length = 25)
    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    @Column(name = "is_disabled", nullable = true)
    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Column(name = "is_mandatory", nullable = true)
    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    @Column(name = "display_order", nullable = true)
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "default_value_id", nullable = true)
    public MetaFieldValue getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(MetaFieldValue defaultValue) {
        if (defaultValue != null)
            defaultValue.setField(this);

        this.defaultValue = defaultValue;
    }

    public MetaFieldValue createValue() {

        return MetaFieldBL.createValueFromDataType(this, null,getDataType());
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name="meta_field_dependency_map",
            joinColumns = @JoinColumn( name="meta_field_id"),
            inverseJoinColumns = @JoinColumn( name="dependent_meta_field_id")
    )
    public Set<MetaField> getDependentMetaFields() {
        return dependentMetaFields;
    }

    public void setDependentMetaFields(Set<MetaField> dependentMetaFields) {
        this.dependentMetaFields = dependentMetaFields;
    }

    @Column(name = "data_table_id")
    public Integer getDataTableId() {
        return dataTableId;
    }

    public void setDataTableId(Integer dataTableId) {
        this.dataTableId = dataTableId;
    }

    @Column(name = "help_description", nullable = true)
    public String getHelpDescription() {
        return helpDescription;
    }

    public void setHelpDescription(String helpDescription) {
        this.helpDescription = helpDescription;
    }

    @Column(name = "help_content_url", nullable = true)
    public String getHelpContentURL() {
        return helpContentURL;
    }

    public void setHelpContentURL(String helpContentURL) {
        this.helpContentURL = helpContentURL;
    }

    @Version
    @Column(name="OPTLOCK")
    public Integer getVersionNum() {
        return versionNum;
    }
    public void setVersionNum(Integer versionNum) {
        this.versionNum = versionNum;
    }

    @Override
    public String toString() {
        return "MetaField{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", entityType=" + entityType +
                ", dataType=" + dataType +
                '}';
    }

    @Transient
    protected String getTable() {
        return Constants.TABLE_METAFIELD;
    }

    @Column(name = "is_primary")
    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    @Column (name="field_usage",nullable=true)
    public MetaFieldType getFieldUsage() {
        return fieldUsage;

    }

    public void setFieldUsage(MetaFieldType fieldUsage) {
        this.fieldUsage = fieldUsage;
    }

    @ManyToMany( fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "metaFields",
            targetEntity = MetaFieldGroup.class)
    public Set<MetaFieldGroup> getMetaFieldGroups() {
        return metaFieldGroups;
    }

    public void setMetaFieldGroups(Set<MetaFieldGroup> metaFieldGroups) {
        this.metaFieldGroups = metaFieldGroups;
    }
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "validation_rule_id", nullable = true)
    public ValidationRule getValidationRule() {
        return validationRule;
    }

    public void setValidationRule(ValidationRule validationRule) {
        this.validationRule = validationRule;
    }

    @Column(name = "filename")
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getAuditKey(Serializable id) {
        StringBuilder key = new StringBuilder();
        key.append(getEntityId())
                .append("-")
                .append(id);

        return key.toString();
    }
}
