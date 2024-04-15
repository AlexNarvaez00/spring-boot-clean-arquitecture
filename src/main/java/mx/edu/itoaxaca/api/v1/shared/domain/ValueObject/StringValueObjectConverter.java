package mx.edu.itoaxaca.api.v1.shared.domain.ValueObject;

import jakarta.persistence.AttributeConverter;

public interface StringValueObjectConverter extends AttributeConverter<StringValueObject, String> {
    public abstract StringValueObject getInstance(String data);

    public default String convertToDatabaseColumn(StringValueObject attribute) {
        return attribute == null ? null : attribute.toString();
    }

    public default StringValueObject convertToEntityAttribute(String dbData) {
        return dbData == null ? null : this.getInstance(dbData);
    }
}
