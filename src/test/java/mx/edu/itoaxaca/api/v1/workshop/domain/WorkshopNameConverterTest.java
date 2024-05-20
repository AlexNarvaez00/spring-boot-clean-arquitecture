package mx.edu.itoaxaca.api.v1.workshop.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class WorkshopNameConverterTest {
    
    @Test
    void testConvertToDatabaseColumn() {
        Workshop workshop = WorkshopMother.random();
        var converter = new WorkshopNameConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(workshop.getName());
        assertTrue(primitiveColumn instanceof String);
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new WorkshopNameConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var converter = new WorkshopNameConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column instanceof WorkshopName);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new WorkshopNameConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
   
}
