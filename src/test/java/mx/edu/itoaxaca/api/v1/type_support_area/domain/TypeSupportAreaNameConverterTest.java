package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import mx.edu.itoaxaca.api.v1.shared.FakerService;
import org.junit.jupiter.api.Test;

public class TypeSupportAreaNameConverterTest {

    @Test
    void testConvertToDatabaseColumn() {
        TypeSupportArea type_support_area = TypeSupportAreaMother.random();
        var converter = new TypeSupportAreaTypeConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(
            type_support_area.getType()
        );
        assertTrue(primitiveColumn instanceof String);
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new TypeSupportAreaTypeConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var converter = new TypeSupportAreaTypeConverter();
        var column = converter.convertToEntityAttribute(
            FakerService.create().name().firstName()
        );
        assertTrue(column instanceof TypeSupportAreaType);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new TypeSupportAreaTypeConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
}
