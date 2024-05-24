package mx.edu.itoaxaca.api.v1.workshop.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class WorkshopSpeakerConverterTest {

    @Test
    void testConvertToDatabaseColumn() {
        Workshop workshop = WorkshopMother.random();
        var converter = new WorkshopSpeakerConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(
            workshop.getSpeaker()
        );
        assertTrue(primitiveColumn instanceof String);
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new WorkshopSpeakerConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var workshop = WorkshopMother.random();

        var converter = new WorkshopSpeakerConverter();
        var column = converter.convertToEntityAttribute(
            workshop.getName().getValue()
        );
        assertTrue(column instanceof WorkshopSpeaker);
    }
    
    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new WorkshopSpeakerConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
}
