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
//import com.olp.jpa.common.TenantBasedSearchFilterFactory;
import com.olp.annotations.MultiTenant;
import com.olp.jpa.common.MultiTenantLifeCycleEntity;
//import com.olp.jpa.common.ResourceLink;
//import com.olp.jpa.common.ResourceLinkContainer;
import com.olp.jpa.domain.docu.um.model.UmEnums.RoleSource;
//import com.olp.jpa.util.JpaUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
@Table(name = "trl_roles",uniqueConstraints={@UniqueConstraint(columnNames={"tenant_id","role_code"})})
@AttributeOverride(name="id", column=@Column(name="role_id", nullable=false))
@Cacheable(true)
@NamedQueries({
        //@NamedQuery(name="RoleBean.findByRoleCode", query="SELECT t from RoleEntity t join fetch t.users t1 join fetch t.privilegeList t2 WHERE t.roleCode = :code and (t.tenantId = \'0\' OR t.tenantId = :tenant)")
    @NamedQuery(name="RoleBean.findByRoleCode", query="SELECT t from RoleEntity t WHERE t.roleCode = :code and t.tenantId = :tenant")
})
//
@Indexed(index = "SetupDataIndex")
//@DiscriminatorValue("Role")
//@FullTextFilterDef(name="filter-role-by-tenant", impl=TenantBasedSearchFilterFactory.class)
@MultiTenant(level = MultiTenant.Levels.ONE_N_GLOBAL)
//@SortCriteria(attributes={"roleCode"})
public class RoleEntity extends MultiTenantLifeCycleEntity {
    
    //@KeyAttribute
    @Column(name = "role_code", nullable=false, updatable=false)
    @Fields({
            @Field( index = Index.YES,analyze = Analyze.NO, store = Store.NO)
    })
    private String roleCode;
    
    @Column(name = "role_name")
    @Fields({
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String roleName;
    
    @Column(name = "role_source", nullable=false)
    @Fields({
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    @Enumerated(EnumType.STRING)
    private RoleSource roleSource;
    
    @Column(name = "ext_role_reference")
    private String externalRoleReference;

    @OneToMany(mappedBy="roleRef", cascade={CascadeType.ALL})
    @IndexedEmbedded(includeEmbeddedObjectId=true, depth=1)
    private Set<UserRoleAsscnEntity> users = new HashSet<>();
    
    /*
    @OneToMany(mappedBy="parentRoleRef", cascade={CascadeType.ALL})
    @IndexedEmbedded(includeEmbeddedObjectId=true, depth=1)
    private Set<RolePrivilegeAsscnEntity> privilegeList = new HashSet<>(); // many parent can refer to one role
    
    @OneToMany(mappedBy="roleRef", cascade={CascadeType.ALL})
    @IndexedEmbedded(includeEmbeddedObjectId=true, depth=1)
    private Set<RolePrivilegeAsscnEntity> roleRefList = new HashSet<>();
    */
    
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public RoleSource getRoleSource() {
        return roleSource;
    }

    public void setRoleSource(RoleSource roleSource) {
        this.roleSource = roleSource;
    }

    public String getExternalRoleReference() {
        return externalRoleReference;
    }

    public void setExternalRoleReference(String externalRoleReference) {
        this.externalRoleReference = externalRoleReference;
    }

    public Set<UserRoleAsscnEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserRoleAsscnEntity> users) {
        if (users != null)
            this.users = users;
        else
            this.users.clear();
    }
    /*
    public Set<RolePrivilegeAsscnEntity> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(Set<RolePrivilegeAsscnEntity> privilegeList) {
        if (privilegeList != null)
            this.privilegeList = privilegeList;
        else
            this.privilegeList.clear();
    }

    public Set<RolePrivilegeAsscnEntity> getRoleRefList() {
        return roleRefList;
    }

    public void setRoleRefList(Set<RolePrivilegeAsscnEntity> roleRefList) {
        if (roleRefList != null)
            this.roleRefList = roleRefList;
        else
            this.roleRefList.clear();
    }
    
    public Role convertTo(int mode) {
        
        Role role = new Role();
        
        if (mode <= Constants.CONV_STANDARD_DEFINITION)
            role.setId(id);
        
        role.setTenantId(tenantId);
        role.setPartitionCode("ddsas");
        role.setRoleCode(roleCode);
        role.setRoleName(roleName);
        //role.setRoleSource(roleSource);
        
        if (mode <= Constants.CONV_WITH_REFERENCED_ENTITY && users != null && users.size() > 0) {
            Set<UserRoleAsscn> asscns = new HashSet<>();
            Iterator<UserRoleAsscnEntity> iter = users.iterator();
            while (iter != null && iter.hasNext()) {
                UserRoleAsscnEntity asscnEntity = iter.next();
                UserRoleAsscn asscn = asscnEntity.convertTo(mode);
                asscns.add(asscn);
            }
            role.setUserAsscns(asscns);
        }
        
        if (mode <= Constants.CONV_WITH_REFERENCED_ENTITY && privilegeList != null && privilegeList.size() > 0) {
            Set<RolePrivilegeAsscn> asscns = new HashSet<>();
            Iterator<RolePrivilegeAsscnEntity> iter = privilegeList.iterator();
            while (iter != null && iter.hasNext()) {
                RolePrivilegeAsscnEntity asscnEntity = iter.next();
                RolePrivilegeAsscn asscn = asscnEntity.convertTo(mode);
                asscns.add(asscn);
            }
            role.setRolePrivAsscns(asscns);
        }
        
        if (mode <= Constants.CONV_WITH_REFERENCED_ENTITY && roleRefList != null && !roleRefList.isEmpty()) {
            Set<RolePrivilegeAsscn> childAsscns = new HashSet<>();
            Iterator<RolePrivilegeAsscnEntity> iter = roleRefList.iterator();
            while (iter != null && iter.hasNext()) {
                RolePrivilegeAsscnEntity asscnEntity = iter.next();
                RolePrivilegeAsscn asscn = asscnEntity.convertTo(mode);
                childAsscns.add(asscn);
            }
            //role.setRoleRefAsscns(asscns);
        }
        
        ResourceLink rl = new ResourceLink();
        rl.setRelation("self");
        rl.setHref(Constants.SERVICE_BASE_URL + "/roles/" + roleCode);
        ResourceLinkContainer rlc = new ResourceLinkContainer();
        HashSet<ResourceLink> set = new HashSet<>();
        set.add(rl);
        
        //role.setLinks(rlc);
        
        if (mode <= Constants.CONV_WITH_REVISION_INFO)
            role.setRevisionControl(revisionControl);
        
        return(role);
    }
    
    @Override
    public int hashCode() {
        
        List<Object> values = JpaUtil.getValuesOfComparableFields(this);
        int hash = Objects.hash(values, this.privilegeList, this.roleRefList, this.users);
        
        return(hash);
    }

    @Override
    public boolean equals(Object o) {
        
        if (o == null)
            return false;
	if (getClass() != o.getClass())
            return false;
        
        RoleEntity ot = (RoleEntity) o;
        
        boolean result = JpaUtil.entityComparisonHelper(this, ot);
        if (result) {
            result = result && JpaUtil.entityComparisonHelper(this.privilegeList, ot.privilegeList );
        }
        
        if (result) {
            result = result && JpaUtil.entityComparisonHelper(this.roleRefList, ot.roleRefList);
        }
        
        if (result) {
            result = result && JpaUtil.entityComparisonHelper(this.users, ot.users);
        }
        
        return result;
    }

    */
}
