package mx.edu.itoaxaca.api.v1.shared.domain.ValueObject;

import lombok.Getter;
import mx.edu.itoaxaca.api.v1.shared.domain.errors.IllegalArgumentValueObjectException;

public abstract class IntegerValueObject implements ValueObject<Integer> {

    @Getter
    private Integer value;

    public IntegerValueObject(Integer value) {
        if (!this.isValid(value)) throw new IllegalArgumentValueObjectException(
            "integer",
            "Value <" + value + "> is not valid"
        );
        this.value = value;
    }
}
