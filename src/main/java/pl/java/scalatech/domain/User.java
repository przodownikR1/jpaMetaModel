package pl.java.scalatech.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Builder;

/**
 * @author Sławomir Borowiec 
 * Module name : bootSetting
 * Creating time :  17 wrz 2014 09:49:34
 
 */
@Data
@NoArgsConstructor
@Entity
@ToString(callSuper=true)
@Builder
public class User extends PKEntity<Long>{
    /**
     * 
     */
    private static final long serialVersionUID = -6567709458397827407L;
    private String name;
    private String login;
    private BigDecimal salary;

    public User(String name, String login, BigDecimal salary) {
        super();
        this.name = name;
        this.login = login;
        this.salary = salary;
    }


}
