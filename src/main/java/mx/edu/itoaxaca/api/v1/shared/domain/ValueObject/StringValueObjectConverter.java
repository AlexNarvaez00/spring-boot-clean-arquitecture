package mx.edu.itoaxaca.api.v1.shared.domain.ValueObject;

import jakarta.persistence.AttributeConverter;

public abstract class StringValueObjectConverter
    implements AttributeConverter<StringValueObject, String> {

    public abstract StringValueObject getInstance(String data);

    @Override
    public String convertToDatabaseColumn(StringValueObject attribute) {
        return attribute == null ? null : attribute.toString();
    }

    @Override
    public StringValueObject convertToEntityAttribute(String dbData) {
        return dbData == null ? null : this.getInstance(dbData);
    }
}
