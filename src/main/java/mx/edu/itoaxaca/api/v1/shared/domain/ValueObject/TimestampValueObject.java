package mx.edu.itoaxaca.api.v1.shared.domain.ValueObject;

import java.time.LocalDateTime;
import lombok.Getter;
import mx.edu.itoaxaca.api.v1.shared.domain.errors.IllegalArgumentValueObjectException;

public abstract class TimestampValueObject
    implements ValueObject<LocalDateTime> {

    @Getter
    private LocalDateTime value;

    public TimestampValueObject(LocalDateTime value) {
        if (!this.isValid(value)) throw new IllegalArgumentValueObjectException(
            "timestamp",
            "Value <" + value + "> is not valid"
        );
        this.value = value;
    }

    @Override
    public boolean isValid(LocalDateTime value) {
        return value != null;
    }

    @Override
    public String toString() {
        return this.getValue().toString();
    }
}
