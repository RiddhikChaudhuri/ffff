/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;

/**
 *
 * @author raghosh
 */
public class OlpPersistenceUnitPostProcessor implements PersistenceUnitPostProcessor {

    
    @Override
    public void postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo mpui) {
        
        String unitName = mpui.getPersistenceUnitName();
        
        //System.out.println("*** PUPP Persistence Unit Name : " + unitName);
        
        PersistenceTypes type = PersistenceTypes.getType(unitName);
        //if (type == null)
        //    throw new IllegalArgumentException("No persistence unit defined for " + unitName);
        Map map = type.getProperties();
        Properties p = mpui.getProperties();
        if (p == null)
            p =  new Properties();
        if (map != null) {
            Iterator iter = map.keySet().iterator();
            while (iter != null && iter.hasNext()) {
                String s = (String) iter.next();
                p.put(s, map.get(s));
            }
        }
        
        //p.setProperty("jpaDialect", unitName)
        
        mpui.setProperties(p);
        
        //System.out.println("*** Done setting persistence unit properties");
    }
    
}
