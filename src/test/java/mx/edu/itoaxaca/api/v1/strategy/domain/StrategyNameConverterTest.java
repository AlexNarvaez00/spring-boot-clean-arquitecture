package mx.edu.itoaxaca.api.v1.strategy.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StrategyNameConverterTest {

    @Test
    void testConvertToDatabaseColumn() {
        Strategy strategy = StrategyMother.random();
        var converter = new StrategyNameConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(
            strategy.getName()
        );
        assertTrue(primitiveColumn instanceof String);
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new StrategyNameConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var converter = new StrategyNameConverter();
        var column = converter.convertToEntityAttribute("ssdc");
        assertTrue(column instanceof StrategyName);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new StrategyNameConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
}
