/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.domain.docu.um.service;

import com.olp.jpa.common.IJpaService;
import com.olp.jpa.domain.docu.um.model.UserEntity;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author raghosh
 */
@NoRepositoryBean
public interface UserService extends IJpaService<UserEntity, Long> {
    
    public UserEntity findByUserName(String name);
    
}
