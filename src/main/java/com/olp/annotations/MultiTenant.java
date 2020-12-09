/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author raghosh
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MultiTenant {
    
    public Levels level();
    
    public String fieldName() default "tenantId";
    
    public enum Levels {
        NO_MT,
        ONE_TENANT,
        ONE_N_GLOBAL,  // Any tenant can access global data and its own tenant specific data
        ALLOW_GLOBAL   // Allow global users to access the tenant specific data
    }
    
}
