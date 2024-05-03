package mx.edu.itoaxaca.api.v1.strategy.domain;

import jakarta.persistence.AttributeConverter;

public class StrategyNameConverter 
    implements AttributeConverter<StrategyName, String> {

    @Override
    public String convertToDatabaseColumn(StrategyName attribute) {
        return (attribute == null) ? null : attribute.getValue();
    }

    @Override
    public StrategyName convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : new StrategyName(dbData);
    }
}
