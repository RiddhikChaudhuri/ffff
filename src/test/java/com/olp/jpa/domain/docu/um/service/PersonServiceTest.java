/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.domain.docu.um.service;

import com.olp.fwk.common.BaseSpringAwareTest;
import com.olp.jpa.domain.docu.um.model.PersonEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author raghosh
 */
public class PersonServiceTest extends BaseSpringAwareTest {
    
    @Autowired
    @Qualifier("personService")
    private PersonService svc;
    
    @Test
    public void test_add1() {
        PersonEntity p = makePerson("123");
        svc.addPerson(p);
    }
    
    
    private PersonEntity makePerson(String uid) {
        PersonEntity p = new PersonEntity();
        p.setPerson_code("ABC_XYZ" + uid);
        p.setPerson_name("Abc Xyz" + uid);
        return(p);
    }
}
