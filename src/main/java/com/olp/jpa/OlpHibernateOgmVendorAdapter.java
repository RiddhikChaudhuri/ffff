/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa;

import ch.qos.logback.core.db.dialect.H2Dialect;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceProvider;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.DB2Dialect;
import org.hibernate.dialect.DerbyDialect;
import org.hibernate.dialect.HSQLDialect;
import org.hibernate.dialect.InformixDialect;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.Oracle9iDialect;
import org.hibernate.dialect.PostgreSQLDialect;
import org.hibernate.dialect.SQLServerDialect;

import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import static org.springframework.orm.jpa.vendor.Database.DB2;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 *
 * @author raghosh
 */
public class OlpHibernateOgmVendorAdapter extends AbstractJpaVendorAdapter {
    
    private final HibernateJpaDialect jpaDialect = new HibernateJpaDialect();
    
    private final PersistenceProvider persistenceProvider;
    
    private final Class<? extends EntityManagerFactory> entityManagerFactoryInterface;
    
    private final Class<? extends EntityManager> entityManagerInterface;

    
    public OlpHibernateOgmVendorAdapter() {
        
        super();
        
        Logger logger = Logger.getLogger(getClass().getName());
        
        logger.log(Level.INFO, "Begin OlpHibernateOgmVendorAdaptor");
        
        ClassLoader cl = OlpHibernateOgmVendorAdapter.class.getClassLoader();
        
        logger.log(Level.INFO, "Class Loader - {0}", cl.getClass().getName());
        
        //String s = "com.olp.jpa.domain.docu.product.ProductTemplateBean";
        //try {
            
        //    cl.loadClass(s);
        //    logger.log(Level.INFO, "Found entity class - {0}", s);
        //} catch (ClassNotFoundException ex) {
        //    logger.log(Level.SEVERE, "Could not find entity class - " + s, ex);
        //}
        
        Class<? extends EntityManagerFactory> emfIfcToUse;
        Class<? extends EntityManager> emIfcToUse;
        Class<?> providerClass;
        PersistenceProvider providerToUse;
        
        try {
            try {
                emfIfcToUse = (Class<? extends EntityManagerFactory>) cl.loadClass("org.hibernate.jpa.HibernateEntityManagerFactory");
                emIfcToUse = (Class<? extends EntityManager>) cl.loadClass("org.hibernate.jpa.HibernateEntityManager");
                providerClass = cl.loadClass("org.hibernate.ogm.jpa.HibernateOgmPersistence");
                
            } catch (ClassNotFoundException ex) {
                throw ex;
            }
            providerToUse = (PersistenceProvider) providerClass.newInstance();
        } catch (Exception ex) {
            throw new IllegalStateException("Failed to determine Hibernate PersistenceProvider", ex);
        }
        
        this.persistenceProvider = providerToUse;
        this.entityManagerFactoryInterface = emfIfcToUse;
        this.entityManagerInterface = emIfcToUse;
        
        logger.log(Level.INFO, "End OlpHibernateOgmVendorAdaptor");
    }
    
    @Override
    public PersistenceProvider getPersistenceProvider() {
	return this.persistenceProvider;
    }
    
    @Override
    public String getPersistenceProviderRootPackage() {
	return "org.hibernate";
    }

    @Override
    public Map<String, Object> getJpaPropertyMap() {
	Map<String, Object> jpaProperties = new HashMap<String, Object>();

	if (getDatabasePlatform() != null) {
        	jpaProperties.put(Environment.DIALECT, getDatabasePlatform());
	} else if (getDatabase() != null) {
        	Class<?> databaseDialectClass = determineDatabaseDialectClass(getDatabase());
		if (databaseDialectClass != null) {
			jpaProperties.put(Environment.DIALECT, databaseDialectClass.getName());
		}
	}

	if (isGenerateDdl()) {
		jpaProperties.put(Environment.HBM2DDL_AUTO, "update");
	}
	if (isShowSql()) {
		jpaProperties.put(Environment.SHOW_SQL, "true");
	}

	return jpaProperties;
    }
    
    @SuppressWarnings("deprecation")
    protected Class<?> determineDatabaseDialectClass(Database database) {
	switch (database) {
		case DB2: return DB2Dialect.class;
		case DERBY: return DerbyDialect.class;  // DerbyDialect deprecated in 4.x
		case H2: return H2Dialect.class;
		case HSQL: return HSQLDialect.class;
		case INFORMIX: return InformixDialect.class;
		case MYSQL: return MySQLDialect.class;
		case ORACLE: return Oracle9iDialect.class;
		case POSTGRESQL: return PostgreSQLDialect.class;  // PostgreSQLDialect deprecated in 4.x
		case SQL_SERVER: return SQLServerDialect.class;
		case SYBASE: return org.hibernate.dialect.SybaseDialect.class;  // SybaseDialect deprecated in 3.6 but not 4.x
		default: return null;
	}
    }

    @Override
    public HibernateJpaDialect getJpaDialect() {
	return this.jpaDialect;
    }

    @Override
    public Class<? extends EntityManagerFactory> getEntityManagerFactoryInterface() {
	return this.entityManagerFactoryInterface;
    }

    @Override
    public Class<? extends EntityManager> getEntityManagerInterface() {
        return this.entityManagerInterface;
    }

}
