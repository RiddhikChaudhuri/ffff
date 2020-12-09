/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.domain.docu.um.service;

import com.olp.jpa.common.AbstractRepositoryImpl;
import com.olp.jpa.domain.docu.um.model.UserRoleAsscnEntity;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author raghosh
 */
@Repository("userRoleRepository")
public class UserRoleAsscnRepositoryImpl extends AbstractRepositoryImpl<UserRoleAsscnEntity, Long> implements UserRoleAsscnRepository {

    @Override
    public String getLazyLoadElements() {
        return("");
    }

    @Override
    @Transactional(readOnly=true, noRollbackFor={javax.persistence.NoResultException.class})
    public UserRoleAsscnEntity findAssociation(String userName, String roleCode) {
        //IContext ctx = ContextManager.getContext();
        String tid = "0";
        
        //EntityGraph graph = getEntityManager().getEntityGraph("graph.departmentBean.employees");
        
        TypedQuery<UserRoleAsscnEntity> query = getEntityManager().createNamedQuery("UserRoleAssociation.findByUserAndRole", UserRoleAsscnEntity.class);
        query.setParameter("uname", userName); // TODO: Sanitize input, although low risk due to binding
        query.setParameter("rcode", roleCode);
        query.setParameter("tenant", tid);
        
        UserRoleAsscnEntity bean = query.getSingleResult();
        
        return(bean);
    }
    
}
