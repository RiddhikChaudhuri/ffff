/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.domain.docu.um.service;

import com.olp.jpa.domain.docu.um.model.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author raghosh
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    @Qualifier("roleRepository")
    private RoleRepository roleRepo;

    @Override
    @Transactional(readOnly=true, noRollbackFor={javax.persistence.NoResultException.class})
    public RoleEntity findByRoleName(String name) {
        RoleEntity role = roleRepo.findByRoleName(name);
        
        return(role);
    }

    @Override
    @Transactional(readOnly=true, noRollbackFor={javax.persistence.NoResultException.class})
    public RoleEntity find(Long id) {
        RoleEntity role = roleRepo.getOne(id);
        return(role);
    }

    @Override
    @Transactional
    public RoleEntity add(RoleEntity entity) {
        RoleEntity role = roleRepo.save(entity);
        return(role);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        roleRepo.deleteById(id);
    }
    
}
