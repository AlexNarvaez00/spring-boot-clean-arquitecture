package mx.edu.itoaxaca.api.v1.shared.domain.criteria;

public class Limit {

    private int limit;

    public Limit(int limit) {
        this.limit = limit;
    }

    public int value() {
        return limit;
    }
}
