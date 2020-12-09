/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.common;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Fields;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Resolution;
//import org.hibernate.search.annotations.SortableField;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author raghosh
 */
@XmlRootElement(name="revisionControl", namespace="http://trilia-cloud.com/schema/common/util")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlAccessorOrder(value=XmlAccessOrder.UNDEFINED)
@XmlType(propOrder={"createdById", "createdBy", "creationDate", "revisedById", "revisedBy", "revisionDate", "objectVersionNumber"})
@Embeddable
@Indexed
public class RevisionControlBean implements Serializable {
    
    @XmlElement(name="createdById")
    @Column(name="created_by_id", nullable=false)
    private int createdById;
    
    @XmlElement(name="createdBy")
    @Column(name="created_by", nullable=false)
    @Field(analyze=Analyze.NO)
    private String createdBy;
    
    @XmlElement(name="createdDate")
    @Column(name="created_date", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    @Fields({
        @Field,
        @Field(name="creationDate-sort", index=Index.YES, store=Store.YES, analyze=Analyze.NO)
    })
    //@SortableField
    @DateBridge(resolution=Resolution.SECOND)
    private Date creationDate;
    
    
    @XmlElement(name="revisedById")
    @Column(name="revised_by_id", nullable=false)
    private int revisedById;
    
    @XmlElement(name="revisedBy")
    @Column(name="revised_by", nullable=false)
    @Field(analyze=Analyze.NO)
    private String revisedBy;
    
    @XmlElement(name="revisedDate")
    @Column(name="revision_date", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    @Fields({
        @Field,
        @Field(name="revisionDate-sort", index=Index.YES, store=Store.YES, analyze=Analyze.NO)
    })
    //@SortableField
    @DateBridge(resolution=Resolution.SECOND)
    private Date revisionDate;
    
    @XmlElement(name="objectVersionNumber")
    @Column(name="object_version_number", nullable=false)
    @Field(analyze=Analyze.NO)
    private String objectVersionNumber = "0.0.1";

    public int getCreatedById() {
        return createdById;
    }

    public void setCreatedById(int createdById) {
        this.createdById = createdById;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getRevisedById() {
        return revisedById;
    }

    public void setRevisedById(int revisedById) {
        this.revisedById = revisedById;
    }

    public String getRevisedBy() {
        return revisedBy;
    }

    public void setRevisedBy(String revisedBy) {
        this.revisedBy = revisedBy;
    }

    public Date getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Date revisionDate) {
        this.revisionDate = revisionDate;
    }

    public String getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(String versionNumber) {
        this.objectVersionNumber = versionNumber;
    }
    
    @Override
    public RevisionControlBean clone() {
        RevisionControlBean rev = new RevisionControlBean();
        rev.setCreatedBy(this.createdBy);
        rev.setCreatedById(this.createdById);
        rev.setCreationDate(this.creationDate);
        rev.setRevisedBy(this.revisedBy);
        rev.setRevisedById(this.revisedById);
        rev.setRevisionDate(this.revisionDate);
        rev.setObjectVersionNumber(this.objectVersionNumber);
        
        return(rev);
    }
    
}
