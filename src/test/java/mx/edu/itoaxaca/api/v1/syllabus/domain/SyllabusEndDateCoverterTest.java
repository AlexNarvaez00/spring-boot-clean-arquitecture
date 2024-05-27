package mx.edu.itoaxaca.api.v1.syllabus.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class SyllabusEndDateCoverterTest {

    @Test
    void testConvertToDatabaseColumn() {
        var syllabus = SyllabusMother.random();
        var converter = new SyllabusEndDateCoverter();
        var primitiveColumn = converter.convertToDatabaseColumn(
            syllabus.getEndDate()
        );
        assertTrue(primitiveColumn instanceof LocalDate);
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new SyllabusEndDateCoverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var syllabus = SyllabusMother.random();
        var converter = new SyllabusEndDateCoverter();
        var column = converter.convertToEntityAttribute(
            syllabus.getEndDate().getValue()
        );
        assertTrue(column instanceof SyllabusEndDate);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new SyllabusEndDateCoverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
}
