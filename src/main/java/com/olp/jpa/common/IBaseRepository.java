/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author raghosh
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface IBaseRepository<T, ID> extends JpaRepository<T, ID>{
    
}
