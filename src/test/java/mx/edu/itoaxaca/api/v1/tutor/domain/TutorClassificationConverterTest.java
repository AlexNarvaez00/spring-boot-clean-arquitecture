package mx.edu.itoaxaca.api.v1.tutor.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TutorClassificationConverterTest {
    
    @Test
    void testConvertToDatabaseColumn() {
        Tutor tutor = TutorMother.random();
        var converter = new TutorClassificationConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(tutor.getClassification());
        assertTrue(primitiveColumn instanceof String);
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new TutorClassificationConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var converter = new TutorClassificationConverter();
        var column = converter.convertToEntityAttribute("sdcsdc");
        assertTrue(column instanceof TutorClassification);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new TutorClassificationConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
   
}
