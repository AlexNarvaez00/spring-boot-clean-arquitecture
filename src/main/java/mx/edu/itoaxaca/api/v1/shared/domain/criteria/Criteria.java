package mx.edu.itoaxaca.api.v1.shared.domain.criteria;

public class Criteria {

    private Filters filters;
    private Offset offset;
    private Limit limit;

    public Criteria(Filters filters, Offset offset,Limit limit) {
        this.filters = filters;
        this.offset = offset;
        this.limit = limit;
    }

    public boolean hasFilters(){
        return filters.filters().length > 0;
    }

    public Filter[] filters() {
        return filters.filters();
    }

    public int offset(){
        return this.offset.value();
    }

    public int limit(){
        return this.limit.value();
    }
}
