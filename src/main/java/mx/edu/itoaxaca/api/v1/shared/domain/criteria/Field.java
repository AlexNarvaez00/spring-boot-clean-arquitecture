package mx.edu.itoaxaca.api.v1.shared.domain.criteria;

public class Field {
    private String field;

    public Field(String field) {
        this.field = field;
    }

    public String value() {
        return field;
    }
}
