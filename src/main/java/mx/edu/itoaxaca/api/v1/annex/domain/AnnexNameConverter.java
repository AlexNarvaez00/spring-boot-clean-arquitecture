package mx.edu.itoaxaca.api.v1.annex.domain;

import jakarta.persistence.AttributeConverter;

public class AnnexNameConverter 
    implements AttributeConverter<AnnexName, String> {

    @Override
    public String convertToDatabaseColumn(AnnexName attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public AnnexName convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new AnnexName(dbData);
    }
}
