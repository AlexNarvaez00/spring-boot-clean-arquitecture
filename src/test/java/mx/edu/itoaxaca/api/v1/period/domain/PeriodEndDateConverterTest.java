package mx.edu.itoaxaca.api.v1.period.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class PeriodEndDateConverterTest {

    @Test
    void testConvertToDatabaseColumn() {
        Period period = PeriodMother.random(true);
        var converter = new PeriodEndDateConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(period.getEndDate());
        assertTrue(primitiveColumn instanceof LocalDate);
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new PeriodEndDateConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var converter = new PeriodEndDateConverter();
        var column = converter.convertToEntityAttribute(LocalDate.now());
        assertTrue(column instanceof PeriodEndDate);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new PeriodEndDateConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
}
