package mx.edu.itoaxaca.api.v1.profile.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import mx.edu.itoaxaca.api.v1.shared.domain.PasswordMother;
import org.junit.jupiter.api.Test;

public class ProfilePasswordConverterTest {

    @Test
    void testConvertToDatabaseColumn() {
        Profile profile = ProfileMother.random();
        var converter = new ProfilePasswordConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(
            new ProfilePassword(PasswordMother.random())
        );
        assertTrue(primitiveColumn instanceof String);
    }

    @Test
    void testConvertToDatabaseColumnWithValueNull() {
        Profile profile = ProfileMother.random();
        var converter = new ProfilePasswordConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var converter = new ProfilePasswordConverter();
        var column = converter.convertToEntityAttribute(
            PasswordMother.random()
        );
        assertTrue(column instanceof ProfilePassword);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new ProfilePasswordConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
}
