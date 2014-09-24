package pl.java.scalatech.old;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class EntityCommon implements Serializable {

    private static final long serialVersionUID = -7901407735478652066L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, precision = 38, scale = 0)
    @Getter
    protected Long id;

    @Basic(fetch = FetchType.LAZY)
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_MODIFICATION")
    @Getter
    @Setter
    protected Date dateModification;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_ADDED", nullable = false)
    @Getter
    @Setter
    protected Date dateAdded = new Date();

    @Transient
    @Basic(fetch = FetchType.LAZY)
    @Getter
    @Setter
    protected String token;
}