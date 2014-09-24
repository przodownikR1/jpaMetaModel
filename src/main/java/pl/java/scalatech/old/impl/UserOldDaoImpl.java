package pl.java.scalatech.old.impl;


import org.springframework.stereotype.Repository;

import pl.java.scalatech.old.UserOldDao;
import pl.java.scalatech.old.domain.OldUser;

@Repository
public class UserOldDaoImpl extends GenericDaoJPA<OldUser, Long> implements UserOldDao {

    @Override
    public OldUser findUserByLogin(String login) {
        // TODO

        throw new RuntimeException("implemention arise in the future.... maybe:)");
    }

}
