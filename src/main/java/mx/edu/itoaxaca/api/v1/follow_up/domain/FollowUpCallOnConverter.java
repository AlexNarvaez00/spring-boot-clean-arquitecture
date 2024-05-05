package mx.edu.itoaxaca.api.v1.follow_up.domain;

import java.time.LocalDate;

import jakarta.persistence.AttributeConverter;

public class FollowUpCallOnConverter 
    implements AttributeConverter<FollowUpCallOn, LocalDate> {

    @Override
    public LocalDate convertToDatabaseColumn(FollowUpCallOn attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public FollowUpCallOn convertToEntityAttribute(LocalDate dbData) {
        return (dbData == null) ? null : new FollowUpCallOn(dbData);
    }
}
