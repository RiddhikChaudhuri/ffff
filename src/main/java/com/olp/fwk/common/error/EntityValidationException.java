/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.fwk.common.error;

/**
 *
 * @author raghosh
 */
public class EntityValidationException extends Exception {
    
    public EntityValidationException(String message) {
        super(message);
    }
    
    public EntityValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public EntityValidationException(Throwable cause) {
        super(cause);
    }
    
    
    
}
