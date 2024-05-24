package mx.edu.itoaxaca.api.v1.type_date.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TypeDateNameConverterTest {

    @Test
    void testConvertToDatabaseColumn() {
        TypeDate type_date = TypeDateMother.random();
        var converter = new TypeDateNameConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(
            type_date.getName()
        );
        assertTrue(primitiveColumn instanceof String);
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new TypeDateNameConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var typeDate = TypeDateMother.random();

        var converter = new TypeDateNameConverter();
        var column = converter.convertToEntityAttribute(
            typeDate.getName().getValue()
        );
        assertTrue(column instanceof TypeDateName);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new TypeDateNameConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
}
