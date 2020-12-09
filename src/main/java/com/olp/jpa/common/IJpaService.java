/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.common;

import com.olp.fwk.common.error.EntityValidationException;
import com.olp.jpa.common.CommonEnums.EntityVdationType;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;


/**
 * 
 * @author raghosh
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface IJpaService<T extends BaseEntity, ID extends Serializable> {
    
    //public List<T> findAll();
    
    //public List<T> findAll(SortCriteriaBean sort);
    
    //public Page<T> findAll(Pageable req);
    
    //public List<T> findText(String keywords, boolean fuzzy, SortCriteriaBean sort);
    
    //public Page<T> findText(String keywords, boolean fuzzy, Pageable req);
    
    //public List<T> findText(SearchCriteriaBean search, SortCriteriaBean sort);
    
    //public Page<T> findText(SearchCriteriaBean search, Pageable req);
    
    public T find(ID id);
    
    //public List<T> find(List<ID> itrbl);
    
    public T add(T entity);
    
    //public List<ID> addAll(List<T> itrbl, boolean ignoreError);
    
    //public T update(T entity);
    
    //public T updateLw(T entity);
    
    //public List<ID> updateAll(List<T> list, boolean ignoreError);
    
    //public List<ID> updateLwAll(List<T> list, boolean ignoreError);
    
    public void delete(ID id);
    
    //public void deleteAll(boolean ignoreError);
    
    //public boolean checkForUpdate(T neu, T old);
    
    //public void validate(T entity, boolean valParent, EntityVdationType type) throws EntityValidationException;
    
    
    public static final int ADD = 0;
    
    public static final int ADD_BULK = 1;
    
    public static final int UPDATE = 2;
    
    public static final int UPDATE_BULK = 3;
    
    public static final int UPDATE_LW = 4;
    
    public static final int UPDATE_LW_BULK = 5;
    
    public static final int DELETE = 6;
    
    public static final int DELETE_BULK = 7;
    
    public static final int FIND = 8;
    
    public static final int FIND_BULK = 9;
    
}
