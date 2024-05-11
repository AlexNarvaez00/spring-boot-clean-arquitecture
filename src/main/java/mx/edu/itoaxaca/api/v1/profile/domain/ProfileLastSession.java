package mx.edu.itoaxaca.api.v1.profile.domain;

import java.time.LocalDateTime;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.TimestampValueObject;

public class ProfileLastSession extends TimestampValueObject{
    public ProfileLastSession(LocalDateTime value) {
        super(value);
    }
}
