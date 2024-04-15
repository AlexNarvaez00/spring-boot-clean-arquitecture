package mx.edu.itoaxaca.api.v1.career.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class CareerNameConverter implements AttributeConverter<CareerName, String> {

    @Override
    public String convertToDatabaseColumn(CareerName arg0) {
        return arg0 == null ? null : arg0.getValue().toString();
    }

    @Override
    public CareerName convertToEntityAttribute(String arg0) {
        return arg0 == null ? null : new CareerName(arg0);
    }
}
