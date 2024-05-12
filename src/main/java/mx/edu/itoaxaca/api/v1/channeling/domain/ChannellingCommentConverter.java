package mx.edu.itoaxaca.api.v1.channeling.domain;

import jakarta.persistence.AttributeConverter;

public class ChannellingCommentConverter 
    implements AttributeConverter<ChannellingComment, String> {

    @Override
    public String convertToDatabaseColumn(ChannellingComment attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public ChannellingComment convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new ChannellingComment(dbData);
    }
}
