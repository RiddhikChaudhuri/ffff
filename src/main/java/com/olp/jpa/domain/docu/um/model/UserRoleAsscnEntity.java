/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.domain.docu.um.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Fields;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
//import com.olp.annotations.MultiTenant;
//import com.olp.annotations.SortCriteria;
//import com.olp.fwk.common.Constants;
import com.olp.annotations.MultiTenant;
import com.olp.annotations.SortCriteria;
import com.olp.jpa.common.MultiTenantLifeCycleEntity;

/**
 *
 * @author raghosh
 */
@Entity
@Table(name = "trl_user_role_associations" , uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_id", "user_name", "role_code"})})
@AttributeOverride(name="id", column=@Column(name="user_role_asscn_id"))
@Cacheable(true)
@Indexed(index = "SetupDataIndex")
@NamedQueries({
        @NamedQuery(name="UserRoleAssociation.findByUser", query="SELECT t from UserRoleAsscnEntity t WHERE userRef.id = :id and tenantId = :tenant"),
        @NamedQuery(name="UserRoleAssociation.findByUserAndRole", query="SELECT t from UserRoleAsscnEntity t WHERE userRef.userName = :uname AND roleRef.roleCode = :rcode AND tenantId = :tenant")
})
@DiscriminatorValue("UserRoleAssociation")
//@FullTextFilterDef(name="filter-ur-asscn-by-tenant", impl=TenantBasedSearchFilterFactory.class)
@MultiTenant(level = MultiTenant.Levels.ONE_TENANT)
@SortCriteria(attributes={"roleCode"})
public class UserRoleAsscnEntity extends MultiTenantLifeCycleEntity {
    
    //@KeyAttribute
    @ManyToOne
    @JoinColumn(name="user_ref")
    @ContainedIn
    private UserEntity userRef;
    
    @Fields({
        @Field(analyze = Analyze.NO, store = Store.NO)
    })
    @Column(name="user_name", nullable=false, updatable=false)
    private String user;
    
    //@KeyAttribute
    @ManyToOne
    @JoinColumn(name="role_ref")
    @ContainedIn
    private RoleEntity roleRef;
    
    @Fields({
        @Field(analyze = Analyze.NO, store = Store.NO)
    })
    @Column(name="role_code", nullable=false, updatable=false)
    private String role;

    public UserEntity getUserRef() {
        return userRef;
    }

    public void setUserRef(UserEntity userRef) {
        this.userRef = userRef;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public RoleEntity getRoleRef() {
        return roleRef;
    }

    public void setRoleRef(RoleEntity roleRef) {
        this.roleRef = roleRef;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    /*
    public UserRoleAsscn convertTo(int mode) {
        
        UserRoleAsscn asscn = new UserRoleAsscn();
        
        if (mode <= Constants.CONV_STANDARD_DEFINITION)
            asscn.setId(this.id);
        
        asscn.setTenantId(this.tenantId);
        asscn.setPartitionCode("asdas");
        
        asscn.setIsEnabled(this.isEnabled);
        asscn.setStatus(this.status);
        asscn.setWorkflowStatus(this.workflowStatus);
        
        if (roleRef != null)
            asscn.setRoleCode(roleRef.getRoleCode());
        if (userRef != null)
            asscn.setUserName(userRef.getUserName());
        
        if (mode <= Constants.CONV_WITH_REVISION_INFO)
            asscn.setRevisionControl(this.revisionControl);
        
        return(asscn);
    }
    
    @Override
    public int hashCode() {
        
        List<Object> values = JpaUtil.getValuesOfComparableFields(this);
        int hash = Objects.hash(values);
        
        return(hash);
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final UserRoleAsscnEntity other = (UserRoleAsscnEntity) obj;
        //if (!Objects.equals(this.userRef, other.userRef)) {
        //    return false;
        //}
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        //if (!Objects.equals(this.roleRef, other.roleRef)) {
        //    return false;
        //}
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        
        return true;
    }
    */
}
