package pl.java.scalatech.domain;


import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class PKEntity<T> implements PKNature<T>  {
    /**
	 * 
	 */
    private static final long serialVersionUID = 7669211182758111346L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected T id;

    protected boolean disabled;

    @Temporal(TemporalType.TIMESTAMP)
    @Basic(fetch = FetchType.LAZY)
    protected Date dateModification;

    @Temporal(TemporalType.TIMESTAMP)
    @Basic(fetch = FetchType.LAZY)
    protected Date dateAdded;

    @PrePersist
    private void initPrePersist() {
        dateAdded = new Date();
    }

    @PreUpdate
    private void initPreUpdate() {
        dateModification = new Date();
        if (dateAdded == null) {
            dateAdded = dateModification;
        }

    }

}