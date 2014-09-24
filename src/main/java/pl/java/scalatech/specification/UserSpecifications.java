package pl.java.scalatech.specification;

import java.math.BigDecimal;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import pl.java.scalatech.domain.User;
import pl.java.scalatech.domain.User_;

/**
 * @author Sławomir Borowiec 
 * Module name : metaModel
 * Creating time :  24 wrz 2014 14:04:54
 
 */
public class UserSpecifications {

    public static Specification<User> getUserByLogin(final String str) {
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> personRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(personRoot.<String> get(User_.login), str);
            }
        };
    }

    public static Specification<User> getUsersWhoEarMoreThan(final BigDecimal salary) {
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> personRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.greaterThan(personRoot.<BigDecimal> get(User_.salary), salary);
            }
        };
    }
}