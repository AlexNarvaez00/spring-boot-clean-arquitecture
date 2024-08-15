package mx.edu.itoaxaca.api.v1.shared.domain.criteria;

import java.util.Map;

public class Filter {

    private Field field;
    private Operator operator;
    private Value value;

    public Filter(Field field, Operator operator, Value value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    public Field field() {
        return field;
    }

    public String operator() {
        return operator.value();
    }

    public Object value() {
        return value.value();
    }

    public static Filter fromValues(Map<String, String> values)
        throws IllegalArgumentException {
        String field = values.get("field");
        String operator = values.get("operator");
        String value = values.get("value");

        if (field == null || operator == null || value == null) {
            throw new IllegalArgumentException(
                "The field, operator and value to be defined"
            );
        }
        return new Filter(
            new Field(field),
            Operator.fromValue(operator),
            new Value(value)
        );
    }
}
