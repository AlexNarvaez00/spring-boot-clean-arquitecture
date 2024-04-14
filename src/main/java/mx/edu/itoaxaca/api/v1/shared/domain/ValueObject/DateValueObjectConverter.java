package mx.edu.itoaxaca.api.v1.shared.domain.ValueObject;

import jakarta.persistence.AttributeConverter;
import java.time.LocalDate;

public abstract class DateValueObjectConverter
    implements AttributeConverter<DateValueObject, LocalDate> {

    public abstract DateValueObject getInstance(LocalDate data);

    @Override
    public LocalDate convertToDatabaseColumn(DateValueObject attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public DateValueObject convertToEntityAttribute(LocalDate dbData) {
        return this.getInstance(dbData);
    }
}
