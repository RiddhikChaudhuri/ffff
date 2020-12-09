/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.domain.docu.um.model;

//import com.olp.annotations.DataClass;
//import com.olp.annotations.DataClass.ClassType;
//import com.olp.annotations.KeyAttribute;
//import com.olp.annotations.MultiTenant;
//import com.olp.annotations.SortCriteria;
//import com.olp.fwk.common.Constants;
//import com.olp.jpa.common.ResourceLink;
//import com.olp.jpa.common.ResourceLinkContainer;
//import com.olp.jpa.common.TenantBasedSearchFilterFactory;
import com.olp.annotations.MultiTenant;
import com.olp.jpa.common.MultiTenantLifeCycleEntity;
import com.olp.jpa.domain.docu.um.model.UmEnums.UserType;
//import com.olp.jpa.util.JpaUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Fields;
import org.hibernate.search.annotations.FullTextFilterDef;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author raghosh
 */
@Entity
//@DataClass(ClassType.MASTER_DATA)
@Table(name = "trl_users", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_id", "user_name"}), @UniqueConstraint(columnNames = {"tenant_id", "primary_email"})} )
@AttributeOverride(name="id", column=@Column(name="user_id", nullable=false, updatable=false))
@Cacheable(true)
@NamedQueries({
        @NamedQuery(name="UserBean.findByUserName", query="SELECT t from UserEntity t join fetch t.roles WHERE t.userName = :name and t.tenantId = :tenant")
})
@Indexed(index = "SetupDataIndex")
//@FullTextFilterDef(name="filter-users-by-tenant", impl=TenantBasedSearchFilterFactory.class)
@MultiTenant(level = MultiTenant.Levels.ONE_TENANT)
//@SortCriteria(attributes={"userName"})
public class UserEntity extends MultiTenantLifeCycleEntity {
    
    //@KeyAttribute
    @Column(name = "user_name", nullable=false, updatable=false)
    @Fields({
        @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String userName;
    
    @Column(name = "user_type")
    @Fields({
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    @Enumerated(EnumType.STRING)
    private UserType userType;
    
    // Due to GDPR type issues, primary email is used by user to login
    // which can be erased with dummy one if the person decides to leave the merchant on trila
    // user name is auto-generated internal one, which is not PII
    @Column(name = "primary_email", nullable=false)
    @Fields({
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String primaryEmail;
    
    @Column(name = "ldap_reference")
    @Fields({
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    //  @SortableField(forField = "ldapReference-sort")
    private String ldapReference;
    
    @OneToMany(mappedBy="userRef", cascade={CascadeType.ALL})
    @IndexedEmbedded(includeEmbeddedObjectId=true, depth=1)
    private List<UserRoleAsscnEntity> roles = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getLdapReference() {
        return ldapReference;
    }

    public void setLdapReference(String ldapReference) {
        this.ldapReference = ldapReference;
    }

    public List<UserRoleAsscnEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRoleAsscnEntity> roles) {
        if (roles != null)
            this.roles = roles;
        else
            this.roles.clear();
    }
    /*
    public User convertTo(int mode) {
        
        User user = new User();
        
        if (mode <= Constants.CONV_STANDARD_DEFINITION)
            user.setId(this.id);
        
        user.setTenantId(this.tenantId);
        user.setPartitionCode("dffsfsfs");
        
        user.setUserName(this.userName);
        user.setUserType(this.userType);
        user.setIsEnabled(this.isEnabled);
        user.setPrimaryEmail(this.primaryEmail);
        user.setStatus(this.status);
        //user.setStatusChangeDate(this.statusChangeDate);
        user.setLdapReference(this.ldapReference);
        
        ArrayList<UserRoleAsscn> list = new ArrayList<>();
        
        for (int i=0; this.roles != null && i < this.roles.size(); i++) {
            UserRoleAsscnEntity asscn = this.roles.get(i);
            if (asscn != null) {
                UserRoleAsscn ura = asscn.convertTo(mode);
                list.add(ura);
            }
        }
        
        user.setRoleAsscns(list);
        
        ResourceLink rl = new ResourceLink();
        rl.setRelation("self");
        rl.setHref(Constants.SERVICE_BASE_URL + "/users/" + userName);
        ResourceLinkContainer rlc = new ResourceLinkContainer();
        HashSet<ResourceLink> set = new HashSet<>();
        set.add(rl);
        
        user.setLinks(rlc);
        
        user.setWorkflowStatus(this.workflowStatus);
        
        if (mode <= Constants.CONV_WITH_REVISION_INFO)
            user.setRevisionControl(revisionControl);
        
        return(user);
    }
    
    @Override
    public int hashCode() {
        
        List<Object> values = JpaUtil.getValuesOfComparableFields(this);
        int hash = Objects.hash(values, this.roles);
        
        return(hash);
    }
    
    @Override
    public boolean equals(Object o) {
        
        if (o == null)
            return false;
	if (getClass() != o.getClass())
            return false;
        
        UserEntity ot = (UserEntity) o;
        
        boolean result = JpaUtil.entityComparisonHelper(this, ot);
        if (result) {
            result = result && JpaUtil.entityComparisonHelper(this.roles, ot.roles);
        }
        
        return result;
    }
    */
}
