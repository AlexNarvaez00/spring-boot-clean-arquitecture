package mx.edu.itoaxaca.api.v1.workshop.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class WorkshopDateConverterTest {

    @Test
    void testConvertToDatabaseColumn() {
        Workshop workshop = WorkshopMother.random();
        var converter = new WorkshopDateConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(
            workshop.getDate()
        );
        assertTrue(primitiveColumn instanceof LocalDate);
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new WorkshopDateConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var workshop = WorkshopMother.random();

        var converter = new WorkshopDateConverter();
        var column = converter.convertToEntityAttribute(
            workshop.getDate().getValue()
        );
        assertTrue(column instanceof WorkshopDate);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new WorkshopDateConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
}
