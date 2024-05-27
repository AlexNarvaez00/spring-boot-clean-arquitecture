package mx.edu.itoaxaca.api.v1.syllabus.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class SyllabusStartDateCoverterTest {

    @Test
    void testConvertToDatabaseColumn() {
        var syllabus = SyllabusMother.random();
        var converter = new SyllabusStartDateCoverter();
        var primitiveColumn = converter.convertToDatabaseColumn(
            syllabus.getStartDate()
        );
        assertTrue(primitiveColumn instanceof LocalDate);
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new SyllabusStartDateCoverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var syllabus = SyllabusMother.random();
        var converter = new SyllabusStartDateCoverter();
        var column = converter.convertToEntityAttribute(
            syllabus.getStartDate().getValue()
        );
        assertTrue(column instanceof SyllabusStartDate);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new SyllabusStartDateCoverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
}
