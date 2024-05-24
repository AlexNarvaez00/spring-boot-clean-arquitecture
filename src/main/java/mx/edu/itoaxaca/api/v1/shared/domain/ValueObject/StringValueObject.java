package mx.edu.itoaxaca.api.v1.shared.domain.ValueObject;

import lombok.Getter;
import mx.edu.itoaxaca.api.v1.shared.domain.errors.IllegalArgumentValueObjectException;

public abstract class StringValueObject implements ValueObject<String> {

    @Getter
    private String value;

    public StringValueObject(String value) {
        if (!this.isValid(value)) throw new IllegalArgumentValueObjectException(
            "string",
            "Value <" + value + "> is not valid"
        );
        this.value = value;
    }

    @Override
    public boolean isValid(String value) {
        return value != null;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
