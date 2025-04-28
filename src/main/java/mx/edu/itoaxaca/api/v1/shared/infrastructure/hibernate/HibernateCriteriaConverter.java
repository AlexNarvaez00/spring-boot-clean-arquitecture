package mx.edu.itoaxaca.api.v1.shared.infrastructure.hibernate;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.HashMap;
import java.util.function.BiFunction;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Filter;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Operator;

public class HibernateCriteriaConverter<T> {

    private final CriteriaBuilder builder;
    private final HashMap<
        Operator,
        BiFunction<Filter, Root<T>, Predicate>
    > predicateTransformers = new HashMap<
        Operator,
        BiFunction<Filter, Root<T>, Predicate>
    >();

    public HibernateCriteriaConverter(CriteriaBuilder builder) {
        this.builder = builder;
    }
}
