/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa;

import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author raghosh
 */
public class PersistenceUtil {
    
    public static EntityManager getEntityManager(String unit) {
        
        EntityManagerFactory factory = getEntityManagerFactory(unit);
        EntityManager em = factory.createEntityManager();
        
        return(em);
    }
    
    public static EntityManagerFactory getEntityManagerFactory(String unit) {
        
        PersistenceTypes type = PersistenceTypes.getType(unit);
        if (type == null)
            throw new IllegalArgumentException("No persistence unit defined for " + unit);
        Map map = type.getProperties();
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(unit, map);
        
        return(factory);
    }
    
}
