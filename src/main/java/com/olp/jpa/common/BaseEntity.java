/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olp.jpa.common;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 *
 * @author raghosh
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    
    protected static final int HASHCODE_SEED = 31;
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @DocumentId
    protected Long id;
    
    @Embedded
    @IndexedEmbedded
    protected RevisionControlBean revisionControl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RevisionControlBean getRevisionControl() {
        return revisionControl;
    }

    public void setRevisionControl(RevisionControlBean revisionControl) {
        this.revisionControl = revisionControl;
    }
    
}
