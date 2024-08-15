package mx.edu.itoaxaca.api.v1.shared.domain.criteria;

import java.util.HashMap;
import java.util.Map;

public class Operator {

    public static final Operator EQUALS = new Operator("=");
    public static final Operator INCLUDE = new Operator("INCLUDE");

    private String value;

    public Operator(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static Operator fromValue(String value) {
        Map<String, Operator> operators = new HashMap<String, Operator>();
        operators.put(EQUALS.value, EQUALS);
        operators.put(INCLUDE.value, INCLUDE);

        return operators.get(value);
    }
}
