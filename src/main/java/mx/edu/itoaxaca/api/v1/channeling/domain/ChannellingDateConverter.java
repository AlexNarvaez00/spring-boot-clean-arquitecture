package mx.edu.itoaxaca.api.v1.channeling.domain;

import java.time.LocalDate;

import jakarta.persistence.AttributeConverter;

public class ChannellingDateConverter 
    implements AttributeConverter<ChannellingDate, LocalDate> {

    @Override
    public LocalDate convertToDatabaseColumn(ChannellingDate attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public ChannellingDate convertToEntityAttribute(LocalDate dbData) {
        return (dbData == null) ? null : new ChannellingDate(dbData);
    }
}
