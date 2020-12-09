/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.olp.fwk.common;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 *
 * @author raghosh
 */
public class Constants {
    
    public static final String OLP_STARTUP_CONFIG_FILE = "olip.startup.file";
    
    public static final String OLP_STARTUP_MT_ELEMENT_NAME_PROPERTY = "olip.mt";
    
    public static final String OLP_STARTUP_MT_ENABLED_PROPERTY = "enabled";
    
    public static final String OLP_STARTUP_DATAGRID_PROVIDER_PROPERTY = "datagrid.provider";
    
    public static final String OLP_STARTUP_DATAGRID_PROVIDER_NAME_PROPERTY = "provider.name";
    
    public static final String OLP_RESOURCE_GROUP_WEB_THREAD_PROPERTY = "max.conc.web.threads";
    
    public static final String OLP_RESOURCE_GROUP_MOBILE_THREAD_PROPERTY = "max.conc.mobile.threads";
    
    public static final String OLP_UI_THEME_ELEMENT_NAME_PROPERTY = "olip.ui.theme";
    
    public static final String OLP_UI_DEFAULT_THEME_PROPERTY = "default.theme";
    
    public static final String OLP_UI_CURRENT_THEME_PROPERTY = "current.theme";
    
    public static final String OLP_CONFIG_STORE_TENANT_ID_PROPERTY = "config.store.tenant.id";
    
    public static final String OLP_FILE_CONFIG_STORE_DIR_PROPERTY = "config.store.file.dir";
    
    public static final String OLP_RT_PLATFORM_PROPERTY = "olip.platform";
    
    /******************************* Grid Partition / Region Names *****************************/
    
    public static final String JPA_FIELD_METADATA_CACHE = "jpa.field.metadata.cache";
    
    public static final String JPA_SEARCHABLE_FIELD_MAP_CACHE = "jpa.searchable.field.map.cache";
    
    public static final String JPA_SEARCHABLE_FIELD_LIST_CACHE = "jpa.searchable.field.list.cache";
    
    public static final String JPA_SEARCHABLE_FIELD_NAME_CACHE = "jpa.searchable.field.name.cache";
    
    public static final String JPA_TENANT_FILTER_NAME_CACHE = "jpa.tenant.filter.name.cache";
    
    public static final String JPA_ID_FIELD_CACHE = "jpa.id.field.name";
    
    public static final String JPA_REV_CONTROL_FIELD_CACHE = "jpa.revctrl.field.name";
    
    // Note: This is used for populating or querying endDate fields in history tables. Databases have some limits on 
    // max dates they can handle. Hence 31-Dec-4000 is arbitrarily chosen
    public static final Date JPA_MAX_DATE = getMaxDate();
    
    /******************************* Multi-tenancy ***********************************/
    
    public static final String GLOBAL_TENANT_ID = "1001";
    
    
    /*************************************** JPA Related ***************************************/
    
    public static final int DEFAULT_PAGE_SIZE = 10;
    
    public static final String JPA_ENTITY_PACKAGES = "com.olp.jpa, com.xyz.abc, com.abc.xyz";
    
    public static final int TENANT_ID_BASE = 1000;
    
    /************************************** Programmatic Lock related ************************************/
    
    public static final int MAX_PERIOD_BAL_UPDATE_LOCK_RETRY = 5; // TODO: turn this into a configuration parameter
    
    public static final int PERIOD_BAL_UPDATE_LOCK_WAIT_TIMEOUT = 20; // millisecond TODO: turn this into a config param
    
    public static final int MAX_MAT_PL_UPDATE_LOCK_RETRY = 5; // TODO: turn this into a configuration parameter
    
    public static final int MAT_PL_UPDATE_LOCK_WAIT_TIMEOUT = 20; // millisecond TODO: turn this into a config param
    
    /********************************** Service Related Constants *******************************/
    
    public static final String SERVICE_BASE_URL = "/services/sec/rest";
    
    /********************************** JPA ENTITY BEAN Conversion *******************************/
    
    public static final int CONV_COMPLETE_WITH_HISTORY = -1;
    
    public static final int CONV_COMPLETE_DEFINITION = 0;
    
    public static final int CONV_WITH_REVISION_INFO = 1;
    
    public static final int CONV_STANDARD_DEFINITION = 2;
    
    public static final int CONV_WITH_REFERENCED_ENTITY = 4;
    
    /********************************** Functional : Product **********************************/
    
    public static final int MAX_VARIANT_ALLOWED = 8;
    
    public static final String DEFAULT_PRODUCT_CATEGORY = "UNCLASSIFIED";
    
    public static final String DEFAULT_PROD_VARIANT_CODE = "0000";
    
    /********************************** Functional : Misc **********************************/
    
    public static final int DEFAULT_MONEY_PRECISION = 2;
    
    public static final int DEFAULT_QUANTITY_PRECISION = 5;
    
    public static final String SETUP_ADMIN_PRIV = "priv:setupadmin";
    
    public static final String INV_ADMIN_PRIV = "priv:invadmin";
    
    public static final String WH_ADMIN_PRIV = "priv:warehouseadmin";
    
    /********************************** Functional : Inv **********************************/
    
    public static final String DEFAULT_AUTOBATCH_NAME_PREFIX = "AUTOBATCH_" ;
    
    public static final String DEFAULT_AUTOBATCH_MANUFACTURER = "DEFAULT_MFG";
    
    public static final String DEFAULT_MATERIAL_PIPELINE_PREFIX = "MATPL_";
    
    public static final String PIPELINE_LOCK_NAME_PREFIX = "PIPELINE_LOCK-";
    
    public static final String MAT_PL_LOCK_NAME_PREFIX = "MAT_PL-";
    
    public static final String[] INV_SETUP_MANAGERS = {SETUP_ADMIN_PRIV, INV_ADMIN_PRIV, WH_ADMIN_PRIV};
    
    /*************************************** Functions ****************************************/
    
    private static Date getMaxDate() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.setTimeInMillis(0);
        cal.set(2400, 12, 31, 0, 0, 0);
        return(cal.getTime());
    }
}
