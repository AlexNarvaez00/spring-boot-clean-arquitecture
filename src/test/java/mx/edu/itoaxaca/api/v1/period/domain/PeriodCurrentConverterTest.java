package mx.edu.itoaxaca.api.v1.period.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PeriodCurrentConverterTest {

    @Test
    void testConvertToDatabaseColumn() {
        Period period = PeriodMother.random(true);
        var converter = new PeriodCurrentConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(period.getCurrent());
        assertTrue(primitiveColumn instanceof Boolean);
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new PeriodCurrentConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var converter = new PeriodCurrentConverter();
        var column = converter.convertToEntityAttribute(true);
        assertTrue(column instanceof PeriodCurrent);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new PeriodCurrentConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
}
