package pl.java.scalatech.old;

import pl.java.scalatech.old.domain.OldUser;

public interface UserOldDao extends GenericDao<OldUser, Long>{
  
    
    OldUser findUserByLogin(String login);
}
