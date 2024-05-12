package mx.edu.itoaxaca.api.v1.channeling.domain;

import java.time.LocalDate;

import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.DateValueObject;

public class ChannellingDate extends DateValueObject{
    public ChannellingDate(LocalDate value) {
        super(value);
    }
}
