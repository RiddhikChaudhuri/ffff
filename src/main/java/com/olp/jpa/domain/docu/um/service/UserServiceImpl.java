/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.domain.docu.um.service;

import com.olp.jpa.domain.docu.um.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author raghosh
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    
    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepo;
    
    @Override
    @Transactional(readOnly=true, noRollbackFor={javax.persistence.NoResultException.class})
    public UserEntity findByUserName(String name) {
        
        UserEntity user  = userRepo.findByUserName(name);
        
        return(user);
    }

    @Override
    @Transactional(readOnly=true, noRollbackFor={javax.persistence.NoResultException.class})
    public UserEntity find(Long id) {
        
        UserEntity user = userRepo.getOne(id);
        
        return(user);
    }

    @Override
    @Transactional
    public UserEntity add(UserEntity entity) {
        
        UserEntity user = userRepo.save(entity);
        
        return(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepo.deleteById(id);
    }
    
}
