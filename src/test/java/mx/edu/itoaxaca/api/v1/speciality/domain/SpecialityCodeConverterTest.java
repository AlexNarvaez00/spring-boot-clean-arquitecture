package mx.edu.itoaxaca.api.v1.speciality.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SpecialityCodeConverterTest {

    @Test
    void testConvertToDatabaseColumn() {
        Speciality speciality = SpecialityMother.random();
        var converter = new SpecialityCodeConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(
            speciality.getCode()
        );
        assertTrue(primitiveColumn instanceof String);
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new SpecialityCodeConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var converter = new SpecialityCodeConverter();
        var column = converter.convertToEntityAttribute("codigo");
        assertTrue(column instanceof SpecialityCode);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new SpecialityCodeConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
}
