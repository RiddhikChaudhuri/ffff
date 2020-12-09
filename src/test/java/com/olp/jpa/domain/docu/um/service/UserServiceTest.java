/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.domain.docu.um.service;

import com.olp.jpa.common.CommonEnums.LifeCycleStatus;
import com.olp.jpa.common.RevisionControlBean;
import com.olp.jpa.domain.docu.um.model.UmEnums;
import com.olp.jpa.domain.docu.um.model.UserEntity;
import com.olp.fwk.common.BaseSpringAwareTest;
import com.olp.jpa.domain.docu.um.model.UserEntity;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author raghosh
 */
public class UserServiceTest extends BaseSpringAwareTest {
    
    @Autowired
    @Qualifier("userService")
    private UserService userSvc;
    
    @Autowired
    @Qualifier("roleService")
    private RoleService roleSvc;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void test_add() {
        UserEntity user = new UserEntity();
        user.setUserName("abc");
        user.setTenantId("3242");
        user.setUserType(UmEnums.UserType.BACKOFFICE);
        
        user.setStatus(LifeCycleStatus.ACTIVE);
        user.setPrimaryEmail("test@trilia.com");
        RevisionControlBean revisionControl =  new RevisionControlBean();
        revisionControl.setCreatedBy(user.getUserName());
        revisionControl.setRevisedBy(user.getUserName());
        revisionControl.setCreationDate(new Date());
        revisionControl.setRevisionDate(new Date());
        revisionControl.setObjectVersionNumber("123");
        user.setRevisionControl(revisionControl);
        
        userSvc.add(user);
    }
}
