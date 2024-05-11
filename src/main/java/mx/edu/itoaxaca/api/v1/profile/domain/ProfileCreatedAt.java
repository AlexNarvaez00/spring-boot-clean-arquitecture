package mx.edu.itoaxaca.api.v1.profile.domain;

import java.time.LocalDateTime;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.TimestampValueObject;

public class ProfileCreatedAt extends TimestampValueObject{
    public ProfileCreatedAt(LocalDateTime value) {
        super(value);
    }
}
