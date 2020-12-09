/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.common;

import com.olp.jpa.common.CommonEnums.LifeCycleStatus;
import com.olp.jpa.common.CommonEnums.WorkflowStatus;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Fields;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author raghosh
 */
@MappedSuperclass
public class MultiTenantLifeCycleEntity extends MultiTenantEntity {
    
    @Column(name = "status", nullable=false)
    @Fields({
        @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    @Enumerated(EnumType.STRING)
    protected LifeCycleStatus status = LifeCycleStatus.INACTIVE;
    
    @Column(name="lc_status_chg_date", nullable=false)
    @Fields({
        @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    @Temporal(javax.persistence.TemporalType.DATE)
    @DateBridge(resolution=Resolution.SECOND)
    protected Date lcStatusChangeDate;
    
    @Column(name = "enabled_flag", nullable=false)
    @Fields({
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    protected boolean isEnabled = false; // enabled flag is set only when lifecycle status is ACTIVE
    
    @Column(name="workflow_status", nullable=true)
    @Fields({
        @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    @javax.persistence.Enumerated(EnumType.STRING)
    protected WorkflowStatus workflowStatus;
    
    @Column(name="wf_status_chg_date", nullable=true)
    @Fields({
        @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    @Temporal(javax.persistence.TemporalType.DATE)
    @DateBridge(resolution=Resolution.SECOND)
    protected Date wfStatusChangeDate;

    public LifeCycleStatus getStatus() {
        return status;
    }

    public void setStatus(LifeCycleStatus status) {
        this.status = status;
        this.isEnabled = (LifeCycleStatus.ACTIVE == status);
        Calendar cal = Calendar.getInstance();
        this.lcStatusChangeDate = cal.getTime();
    }

    public Date getLcStatusChangeDate() {
        return lcStatusChangeDate;
    }

    //public void setLcStatusChangeDate(Date lcStatusChangeDate) {
    //    this.lcStatusChangeDate = lcStatusChangeDate;
    //}

    public boolean isIsEnabled() {
        return isEnabled;
    }

    //public void setIsEnabled(boolean isEnabled) {
    //    this.isEnabled = isEnabled;
    //}

    public WorkflowStatus getWorkflowStatus() {
        return workflowStatus;
    }

    public void setWorkflowStatus(WorkflowStatus workflowStatus) {
        this.workflowStatus = workflowStatus;
        Calendar cal = Calendar.getInstance();
        this.wfStatusChangeDate = cal.getTime();
    }

    public Date getWfStatusChangeDate() {
        return wfStatusChangeDate;
    }

    //public void setWfStatusChangeDate(Date wfStatusChangeDate) {
    //    this.wfStatusChangeDate = wfStatusChangeDate;
    //}
    
}
