package mx.edu.itoaxaca.api.v1.shared.infrastructure;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Criteria;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Filter;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Operator;
import org.springframework.data.jpa.domain.Specification;

public class JPACriteriaConverter<T> {

    private Map<String, Function<Filter, Specification<T>>> converters;

    public JPACriteriaConverter() {
        this.converters = new HashMap<
            String,
            Function<Filter, Specification<T>>
        >();
        this.converters.put(
                Operator.EQUALS.value(),
                JPACriteriaConverter::equalsPredicate
            );
        this.converters.put(
                Operator.INCLUDE.value(),
                JPACriteriaConverter::likePredicate
            );
    }

    private static <T> Specification<T> equalsPredicate(Filter filter) {
        return (
            Root<T> root,
            CriteriaQuery<?> query,
            CriteriaBuilder builder
        ) -> {
            if (filter.field().value().equals("id")) {
                return builder.equal(
                    root.get(filter.field().value()),
                    UUID.fromString(filter.value().toString())
                );
            }
            return builder.equal(
                root.get(filter.field().value()),
                filter.value()
            );
        };
    }

    private static <T> Specification<T> likePredicate(Filter filter) {
        return (
            Root<T> root,
            CriteriaQuery<?> query,
            CriteriaBuilder builder
        ) -> {
            return builder.like(
                root.get(filter.field().value()),
                "%" + filter.value() + "%"
            );
        };
    }

    public Specification<T> convert(Criteria criteria) {
        Filter[] filters = criteria.filters();

        Function<Filter, Specification<T>> convert =
            this.converters.get(filters[0].operator());

        Specification<T> spec = Specification.where(convert.apply(filters[0]));

        for (int index = 1; index < filters.length; index++) {
            Filter filter = filters[index];
            convert = this.converters.get(filter.operator());
            spec = Specification.where(spec).and(convert.apply(filter));
        }
        return spec;
    }
}
