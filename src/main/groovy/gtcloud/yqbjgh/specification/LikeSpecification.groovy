package gtcloud.yqbjgh.specification

import org.springframework.data.jpa.domain.Specification

import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

class LikeSpecification<T> implements Specification<T> {
    private final String property
    private final String pattern

    LikeSpecification(String property, String pattern) {
        this.property = property
        this.pattern = pattern
    }

    Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.like(root.get(property), pattern)
    }
}
