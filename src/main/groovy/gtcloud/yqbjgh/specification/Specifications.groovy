package gtcloud.yqbjgh.specification

import static javax.persistence.criteria.Predicate.BooleanOperator.AND
import static javax.persistence.criteria.Predicate.BooleanOperator.OR

final class Specifications {
    private Specifications() {
    }

    static <T> PredicateBuilder<T> and() {
        return new PredicateBuilder<>(AND)
    }

    static <T> PredicateBuilder<T> or() {
        return new PredicateBuilder<>(OR)
    }
}
