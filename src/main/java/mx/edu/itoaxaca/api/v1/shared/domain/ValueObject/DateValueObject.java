package mx.edu.itoaxaca.api.v1.shared.domain.ValueObject;

import java.time.LocalDate;
import lombok.Getter;

public abstract class DateValueObject implements ValueObject<LocalDate> {

    @Getter
    private LocalDate value;

    public DateValueObject(LocalDate value) {
        if (!this.isValid(value)) throw new IllegalArgumentException(
            "Value <" + value + "> is not valid"
        );
        this.value = value;
    }

    @Override
    public boolean isValid(LocalDate value) {
        return value != null;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
