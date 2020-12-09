/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.domain.docu.um.service;

import com.olp.jpa.common.AbstractRepositoryImpl;
import com.olp.jpa.domain.docu.um.model.RoleEntity;
import java.util.Optional;
import javax.persistence.TypedQuery;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author raghosh
 */
@Repository("roleRepository")
public class RoleRepositoryImpl extends AbstractRepositoryImpl<RoleEntity, Long> implements RoleRepository {

    @Override
    public String getLazyLoadElements() {
        return("t.users a join fetch t.privilegeList b join fetch t.roleRefList c");
    }

    @Override
    @Transactional(readOnly=true, noRollbackFor={javax.persistence.NoResultException.class})
    public RoleEntity findByRoleName(String name) {
        
        //IContext ctx = ContextManager.getContext();
        //String tid = ctx.getTenantId();
        
        //EntityGraph graph = getEntityManager().getEntityGraph("graph.departmentBean.employees");
        
        TypedQuery<RoleEntity> query = getEntityManager().createNamedQuery("RoleBean.findByRoleCode", RoleEntity.class);
        query.setParameter("code", name); // TODO: Sanitize input, although low risk due to binding
        query.setParameter("tenant", "0");
        
        RoleEntity bean = query.getSingleResult();
        
        return(bean);
        
    }

    @Override
    public Optional<RoleEntity> findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existsById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll(Iterable<? extends RoleEntity> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends RoleEntity> Optional<S> findOne(Example<S> exmpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
