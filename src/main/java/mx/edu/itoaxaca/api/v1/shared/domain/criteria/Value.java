package mx.edu.itoaxaca.api.v1.shared.domain.criteria;

public class Value {

    private Object value;

    public Value(Object value) {
        this.value = value;
    }

    public Object value() {
        return value;
    }
}
