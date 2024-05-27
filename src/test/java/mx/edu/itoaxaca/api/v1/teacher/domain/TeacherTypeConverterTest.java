package mx.edu.itoaxaca.api.v1.teacher.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TeacherTypeConverterTest {
    
    @Test
    void testConvertToDatabaseColumn() {
        Teacher teacher = TeacherMother.random();
        var converter = new TeacherTypeConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(teacher.getType());
        assertTrue(primitiveColumn instanceof String);
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new TeacherTypeConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var converter = new TeacherTypeConverter();
        var column = converter.convertToEntityAttribute("value test");
        assertTrue(column instanceof TeacherType);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new TeacherTypeConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
   
}
