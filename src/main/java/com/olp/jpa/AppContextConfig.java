/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa;


import java.net.UnknownHostException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
//import org.hibernate.ogm.datastore.mongodb.MongoDBDialect;
//import org.hibernate.ogm.datastore.mongodb.impl.MongoDBDatastoreProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author raghosh
 */
//@Configuration
//@EnableJpaRepositories("com.olp.jpa")
//@EnableTransactionManagement
//@ComponentScan("com.olp")
//@EnableLoadTimeWeaving
@SpringBootApplication
@ImportResource({"classpath*:applicationContext.xml"})
//@ImportResource("classpath:applicationContext.xml")
public class AppContextConfig {
    
    /*
    //@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(Environment env) throws UnknownHostException {
        
        PersistenceTypes type = PersistenceTypes.getType("productHub");
        
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        
        JpaVendorAdapter adapter = new OlpHibernateOgmVendorAdapter();
        
        //System.out.println("***** ACC Persistence Provider - " + factoryBean.getPersistenceProvider());
        //System.out.println("***** ACC Persistence Unit Name - " + factoryBean.getPersistenceUnitName());
        
        factoryBean.setBeanName("entityManagerFactory");
        factoryBean.setJpaVendorAdapter(adapter);
        factoryBean.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
        factoryBean.setPersistenceUnitName("productHub");
        factoryBean.setJpaPropertyMap(type.getProperties());
        factoryBean.setPackagesToScan("com.olp.jpa");
        
        HibernateJpaDialect jpaDialect = new HibernateJpaDialect();
        
        factoryBean.setJpaDialect(jpaDialect);
        
        
        //factoryBean.setPersistenceUnitPostProcessors(new OlpPersistenceUnitPostProcessor());
        
        System.out.println("******** Entity Manager Factory Bean - " + factoryBean.getClass().getName());
        
        return(factoryBean);
    }
    
    //@Bean
    public EntityManager getEntityManager(Environment env) throws UnknownHostException {
        JpaVendorAdapter adapter = new OlpHibernateOgmVendorAdapter();
        PersistenceProvider provider = adapter.getPersistenceProvider();
        PersistenceTypes type = PersistenceTypes.PRODUCTHUB;
        EntityManagerFactory fact = provider.createEntityManagerFactory(type.getTypeName(), type.getProperties());
        EntityManager em = fact.createEntityManager();
        return(em);
    }
    
    //@Bean
    public String getPuName() {
        return("productHub");
    }
    
    //@Bean
    public EntityManagerFactory entityManagerFactory(String puName) {
        
        EntityManagerFactory factory = PersistenceUtil.getEntityManagerFactory(puName);
        
        System.out.println("******** Entity Manager Factory - " + factory.getClass().getName());
        
        return(factory);
    }
    
    //@Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        
        return transactionManager;
    }
    */
    
    public static void main(String[] args) {
        SpringApplication.run(AppContextConfig.class, args);
    } 
    
}
