package mx.edu.itoaxaca.api.v1.annex.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.persistence.AttributeConverter;
import mx.edu.itoaxaca.api.v1.shared.JsonParse;

public class AnnexBodyConverter implements AttributeConverter<AnnexBody, String> {

    @Override
    public String convertToDatabaseColumn(AnnexBody attribute) {
        try {
            return (attribute == null) ? null : JsonParse.toJson(attribute.getValue());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AnnexBody convertToEntityAttribute(String dbData) {
        try {
            return (dbData == null) ? null : new AnnexBody(JsonParse.toObject(dbData));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
