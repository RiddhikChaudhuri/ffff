/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa;

//import com.olp.fwk.config.ConfigurationContext;
//import com.olp.fwk.config.impl.MongoPersistenceConfiguration;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author raghosh
 */
public enum PersistenceTypes {
    
    PRODUCTHUB("productHub") {

        @Override
        public Map getProperties() {
            
            ///ConfigurationContext ctx = ConfigurationContext.getInstance();
            //MongoPersistenceConfiguration cfg = ctx.get(MongoPersistenceConfiguration.class);
            //Map map = cfg.getPropertiesAsMap();
            
            //Uncomment above and comment below
            HashMap map = new HashMap();
            
            return(map);
        }
    },
    
    DEFAULT("default") {
        
        @Override
        public Map getProperties() {
            Map map = new HashMap();
            
            return(map);
        }
        
    };
    
    private final String __unitName;
    
    PersistenceTypes(String name) {
        __unitName = name;
    }
    
    public abstract Map getProperties();
    
    public String getTypeName() {
        return(__unitName);
    }
    
    public static PersistenceTypes getType(String name) {
        if (PRODUCTHUB.getTypeName().equalsIgnoreCase(name)) {
            return PRODUCTHUB;
        } else
            return DEFAULT;
    }
    
}
