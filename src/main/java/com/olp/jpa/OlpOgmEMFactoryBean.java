/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa;

import java.io.Serializable;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author raghosh
 */
public class OlpOgmEMFactoryBean implements Serializable {
    
    private String persistenceUnitName;

    public String getPersistenceUnitName() {
        return persistenceUnitName;
    }

    public void setPersistenceUnitName(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }
    
    public EntityManagerFactory getEntityManagerFactory() {
        EntityManagerFactory factory = PersistenceUtil.getEntityManagerFactory(persistenceUnitName);
        return(factory);
    }
    
}
