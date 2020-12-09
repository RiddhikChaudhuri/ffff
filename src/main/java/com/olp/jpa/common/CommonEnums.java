/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.common;

/**
 *
 * @author raghosh
 */
public class CommonEnums {
    
    public static enum AscDsc {
        ASC,
        DESC,
        NONE
    }
    
    public static enum WorkflowStatus {
        NEW,
        IN_PROGRESS,
        ERROR,
        COMPLETE
    }
    
    public static enum LifeCycleStatus {
        INACTIVE,
        ACTIVE,
        SUSPENDED,
        TERMINATED
    }
    
    public static enum LifeCycleAction {
        ACTIVATE,
        SUSPEND,
        TERMINATE
    }
    
    public static enum LifeCycleChangeResponse {
        SUCCESS(0),
        NO_OP(-1),
        ERROR(1);
        
        private final int _responseCode;
        
        private LifeCycleChangeResponse(int response) {
            _responseCode = response;
        }
        
        public int getResponseCode() {
            return(_responseCode);
        }
    }
    
    public static enum EnableDisable {
        ENABLE,
        DISABLE
    }
    
    public static enum YesNo {
        YES,
        NO
    }
    
    public static enum EntityType {
        MERCHANT,
        BANK,
        SUPPLIER,
        USER,
        ROLE
    }
    
    public static enum EntityVdationType {
        PRE_INSERT,
        PRE_UPDATE,
        REFERENCIAL
    }
    
    public static enum CategorySource {
        EMPLOYEE,
        ORG,
        PRODUCT,
        TEMPLATE
    }
    
    public static enum CategoryClass {
        
        XYZ(CategorySource.EMPLOYEE); // TODO: to define the classes for each source
        
        private final CategorySource source;
        
        private CategoryClass(CategorySource source) {
            this.source = source;
        }
        
        public CategorySource getResponseCode() {
            return(source);
        }
    }
    
    public static enum CurrencyCode {
        EUR,
        INR,
        RMB,
        USD
    }
    
    public static enum CalendarMonth {
        
        JAN(1),
        FEB(2),
        MAR(3),
        APR(4),
        MAY(5),
        JUN(6),
        JUL(7),
        AUG(8),
        SEP(9),
        OCT(10),
        NOV(11),
        DEC(12)
        ;
            
        private final int _index;
        
        CalendarMonth(int index) {
            _index = index;
        }
        
        public int getMonthIndex() {
            return(_index);
        }
        
        public static CalendarMonth decode(int i) {
            CalendarMonth month = null;
            switch(i) {
                case 1 : 
                    month = JAN;
                    break;
                case 2 :
                    month = FEB;
                    break;
                case 3 :
                    month = MAR;
                    break;
                case 4 :
                    month = APR;
                    break;
                case 5 :
                    month = MAY;
                    break;
                case 6 :
                    month = JUN;
                    break;
                case 7 :
                    month = JUL;
                    break;
                case 8 :
                    month = AUG;
                    break;
                case 9 :
                    month = SEP;
                    break;
                case 10 :
                    month = OCT;
                    break;
                case 11 :
                    month = NOV;
                    break;
                case 12 :
                    month = DEC;
                    break;
                default :
                    break;
            }
            
            return(month);
        }
    }
    
}
