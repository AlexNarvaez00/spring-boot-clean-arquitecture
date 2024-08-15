package mx.edu.itoaxaca.api.v1.shared.domain.criteria;

import java.util.Arrays;
import java.util.Map;

public class Filters {

    private Filter filters[];

    public Filters(Filter[] filters) {
        this.filters = filters;
    }

    public Filter[] filters() {
        return filters;
    }

    public static Filters fromValues(Map<String, String>[] values) {
        Filter[] filters = Arrays.asList(values)
            .stream()
            .map(Filter::fromValues)
            .toList()
            .toArray(Filter[]::new);
        return new Filters(filters);
    }
}
