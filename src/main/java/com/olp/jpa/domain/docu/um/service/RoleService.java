/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.domain.docu.um.service;

import com.olp.jpa.common.IJpaService;
import com.olp.jpa.domain.docu.um.model.RoleEntity;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author raghosh
 */
@NoRepositoryBean
public interface RoleService extends IJpaService<RoleEntity, Long> {
    
    public RoleEntity findByRoleName(String name);
    
}
