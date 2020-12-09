/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.domain.docu.um.service;

import com.olp.jpa.domain.docu.um.model.UserRoleAsscnEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author raghosh
 */
@Service("userRoleService")
public class UserRoleAsscnServiceImpl implements UserRoleAsscnService {
    
    @Autowired
    @Qualifier("userRoleRepository")
    private UserRoleAsscnRepository userRoleRepo;

    @Override
    @Transactional(readOnly=true, noRollbackFor={javax.persistence.NoResultException.class})
    public UserRoleAsscnEntity findAssociation(String userName, String roleCode) {
        UserRoleAsscnEntity asscn = userRoleRepo.findAssociation(userName, roleCode);
        return(asscn);
    }

    @Override
    @Transactional(readOnly=true, noRollbackFor={javax.persistence.NoResultException.class})
    public UserRoleAsscnEntity find(Long id) {
        UserRoleAsscnEntity asscn = userRoleRepo.getOne(id);
        return(asscn);
    }

    @Override
    @Transactional
    public UserRoleAsscnEntity add(UserRoleAsscnEntity entity) {
        UserRoleAsscnEntity asscn = userRoleRepo.save(entity);
        return(asscn);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRoleRepo.deleteById(id);
    }
    
}
