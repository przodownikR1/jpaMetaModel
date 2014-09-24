package pl.java.scalatech.old.domain;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.java.scalatech.old.EntityCommon;
@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=true)
public class OldUser extends EntityCommon{
    
    private static final long serialVersionUID = -8176350535800888014L;
    private String name;
    private String login;
    private BigDecimal salary;

}
