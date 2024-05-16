package mx.edu.itoaxaca.api.v1.period.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class PeriodStartDateConverterTest {

    @Test
    void testConvertToDatabaseColumn() {
        Period period = PeriodMother.random(true);
        var converter = new PeriodStartDateConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(period.getStartDate());
        assertTrue(primitiveColumn instanceof LocalDate);
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new PeriodStartDateConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var converter = new PeriodStartDateConverter();
        var column = converter.convertToEntityAttribute(LocalDate.now());
        assertTrue(column instanceof PeriodStartDate);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new PeriodStartDateConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
}
