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
public class EntityUCException extends RuntimeException {
    
    public EntityUCException() {
        super();
    }
    
    public EntityUCException(String message) {
        super(message);
    }
    
    public EntityUCException(Throwable cause) {
        super(cause);
    }
    
    public EntityUCException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
