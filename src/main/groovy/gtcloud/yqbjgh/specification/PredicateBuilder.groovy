package gtcloud.yqbjgh.specification

import org.springframework.data.jpa.domain.Specification

import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

import static javax.persistence.criteria.Predicate.BooleanOperator.OR

class PredicateBuilder<T> {

    private final Predicate.BooleanOperator operator

    private List<Specification<T>> specifications

    PredicateBuilder(Predicate.BooleanOperator operator) {
        this.operator = operator
        this.specifications = new ArrayList<>()
    }

    PredicateBuilder<T> between(boolean condition, String property, Float lower, Float upper) {
        return this.predicate(condition, new BetweenSpecification<>(property, lower, upper))
    }

    PredicateBuilder<T> like(boolean condition, String property, String pattern) {
        return this.predicate(condition, new LikeSpecification<>(property, pattern))
    }

    PredicateBuilder<T> predicate(Specification<T> specification) {
        return this.predicate(true, specification)
    }

    PredicateBuilder<T> predicate(boolean condition, Specification<T> specification) {
        if (condition) {
            this.specifications.add(specification)
        }
        return this
    }

    Specification<T> build() {
        return { root, query, cb ->
            buildPredicate(root, query, cb)
        }
    }

    Predicate buildPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate[] predicates = new Predicate[specifications.size()]
        for (int i = 0; i < specifications.size(); i++) {
            predicates[i] = specifications.get(i).toPredicate(root, query, cb)
        }
        if (Objects.equals(predicates.length, 0)) {
            return null
        }
        return OR == operator ? cb | predicates : cb & predicates
    }
}
