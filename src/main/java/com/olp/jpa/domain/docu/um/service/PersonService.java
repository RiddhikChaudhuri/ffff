/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.domain.docu.um.service;

import com.olp.jpa.domain.docu.um.model.PersonEntity;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author raghosh
 */
@Service("personService")
public class PersonService {
    
    @Autowired
    @Qualifier("personRepository")
    private PersonRepository personRepo;
    
    @Transactional
    public PersonEntity addPerson(PersonEntity person) {
        
        PersonEntity p = personRepo.save(person);
        
        return(p);
    }
    
}
