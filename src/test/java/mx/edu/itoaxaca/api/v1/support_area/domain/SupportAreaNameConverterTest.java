package mx.edu.itoaxaca.api.v1.support_area.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SupportAreaNameConverterTest {
    
    @Test
    void testConvertToDatabaseColumn() {
        SupportArea support_area = SupportAreaMother.random();
        var converter = new SupportAreaNameConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(support_area.getName());
        assertTrue(primitiveColumn instanceof String);
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new SupportAreaNameConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var converter = new SupportAreaNameConverter();
        var column = converter.convertToEntityAttribute("data xd");
        assertTrue(column instanceof SupportAreaName);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new SupportAreaNameConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
   
}
