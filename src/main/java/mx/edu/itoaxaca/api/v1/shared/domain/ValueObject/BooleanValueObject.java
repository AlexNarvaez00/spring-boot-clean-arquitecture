package mx.edu.itoaxaca.api.v1.shared.domain.ValueObject;

import lombok.Getter;

public abstract class BooleanValueObject implements ValueObject<Boolean> {
    @Getter
    private Boolean value;

    public BooleanValueObject(Boolean value) {
        this.value = value;
    }
}
