/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.domain.docu.um.service;

import com.olp.jpa.domain.docu.um.model.UserRoleAsscnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author raghosh
 */
@NoRepositoryBean
public interface UserRoleAsscnRepository extends JpaRepository<UserRoleAsscnEntity, Long> {
    
    public UserRoleAsscnEntity findAssociation(String userName, String roleCode); 
    
}
