/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.domain.docu.um.service;

import com.olp.jpa.common.AbstractRepositoryImpl;
import com.olp.jpa.domain.docu.um.model.UserEntity;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author raghosh
 */
@Repository("userRepository")
public class UserRepositoryImpl extends AbstractRepositoryImpl<UserEntity, Long> implements UserRepository {
    
    @Override
    @Transactional(readOnly=true, noRollbackFor={javax.persistence.NoResultException.class})
    public UserEntity findByUserName(String name) {
        
        //IContext ctx = ContextManager.getContext();
        //String tid = ctx.getTenantId();
        
        //EntityGraph graph = getEntityManager().getEntityGraph("graph.departmentBean.employees");
        
        TypedQuery<UserEntity> query = getEntityManager().createNamedQuery("UserBean.findByUserName", UserEntity.class);
        query.setParameter("name", name); // TODO: Sanitize input, although low risk due to binding
        query.setParameter("tenant", 0);
        
        UserEntity bean = query.getSingleResult();
        
        return(bean);
    }

    @Override
    public String getLazyLoadElements() {
        return("");
    }

    @Override
    public boolean existsById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
