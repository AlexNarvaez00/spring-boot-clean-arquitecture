package mx.edu.itoaxaca.api.v1.shared.domain;

import java.time.LocalDateTime;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.TimestampValueObject;

public class CreatedAt extends TimestampValueObject{

    public CreatedAt(LocalDateTime value) {
        super(value);
    }

}
