package mx.edu.itoaxaca.api.v1.shared.domain.criteria;

public class Criteria {

    private Filters filters;

    public Criteria(Filters filters, Limit limit) {
        this.filters = filters;
    }

    public boolean hasFilters(){
        return filters.filters().length > 0;
    }

    public Filter[] filters() {
        return filters.filters();
    }
}
