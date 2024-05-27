package mx.edu.itoaxaca.api.v1.syllabus.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SyllabusCodeConverterTest {

    @Test
    void testConvertToDatabaseColumn() {
        var syllabus = SyllabusMother.random();
        var converter = new SyllabusCodeConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(
            syllabus.getCode()
        );
        assertTrue(primitiveColumn instanceof String);
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new SyllabusCodeConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var syllabus = SyllabusMother.random();

        var converter = new SyllabusCodeConverter();
        var column = converter.convertToEntityAttribute(
            syllabus.getCode().getValue()
        );
        assertTrue(column instanceof SyllabusCode);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new SyllabusCodeConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
}
