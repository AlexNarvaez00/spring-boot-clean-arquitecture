package mx.edu.itoaxaca.api.v1.workshop.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class WorkshopSpeakerInstitutionConverterTest {

    @Test
    void testConvertToDatabaseColumn() {
        Workshop workshop = WorkshopMother.random();
        var converter = new WorkshopSpeakerInstitutionConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(
            workshop.getSpeakerInstitution()
        );
        assertTrue(primitiveColumn instanceof String);
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new WorkshopSpeakerInstitutionConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var workshop = WorkshopMother.random();

        var converter = new WorkshopSpeakerInstitutionConverter();
        var column = converter.convertToEntityAttribute(
            workshop.getName().getValue()
        );
        assertTrue(column instanceof WorkshopSpeakerInstitution);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new WorkshopSpeakerInstitutionConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
}
