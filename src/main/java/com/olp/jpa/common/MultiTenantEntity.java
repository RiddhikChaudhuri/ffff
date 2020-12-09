/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.common;

//import com.olp.annotations.KeyAttribute;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Fields;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author raghosh
 */
@MappedSuperclass
public class MultiTenantEntity extends BaseEntity {
    
    //@KeyAttribute
    @Fields({
            @Field(analyze = Analyze.NO, store = Store.YES)
    })
    @Column(name="tenant_id", nullable=false, updatable=false)
    protected String tenantId;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
    
}
