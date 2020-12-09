/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.fwk.common;

import javax.transaction.Transactional;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author raghosh
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@DataJpaTest
@ContextConfiguration(locations="/application-test-context.xml")
//@Transactional
////@SpringApplicationConfiguration
@SpringBootTest
//@Configurable
public abstract class BaseSpringAwareTest  {
    
    @Autowired
    private ApplicationContext __ctx;
    

    /**
     * @return the __ctx
     */
    protected ApplicationContext getCtx() {
        return __ctx;
    }

}
