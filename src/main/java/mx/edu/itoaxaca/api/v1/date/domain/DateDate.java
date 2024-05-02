package mx.edu.itoaxaca.api.v1.date.domain;

import java.time.LocalDateTime;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.TimestampValueObject;

public class DateDate extends TimestampValueObject{

    public DateDate(LocalDateTime value) {
        super(value);
    }

}
