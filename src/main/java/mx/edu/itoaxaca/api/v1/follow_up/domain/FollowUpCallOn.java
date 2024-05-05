package mx.edu.itoaxaca.api.v1.follow_up.domain;

import java.time.LocalDate;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.DateValueObject;

public class FollowUpCallOn extends DateValueObject{
    public FollowUpCallOn(LocalDate value) {
        super(value);
    }
}
