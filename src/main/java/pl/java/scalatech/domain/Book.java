package pl.java.scalatech.domain;

import javax.persistence.Entity;
import javax.persistence.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Book extends PKEntity<Long> {
    /**
     * 
     */
    private static final long serialVersionUID = -6468584865690890376L;
    private String name;
    private Long price;

    @Version
    private Long version;

}