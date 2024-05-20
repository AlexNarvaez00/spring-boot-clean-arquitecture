package mx.edu.itoaxaca.api.v1.profile.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import mx.edu.itoaxaca.api.v1.shared.FakerService;
import org.junit.jupiter.api.Test;

public class ProfileNameConverterTest {

    @Test
    void testConvertToDatabaseColumn() {
        Profile profile = ProfileMother.random();
        var converter = new ProfileNameConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(
            profile.getName()
        );
        assertTrue(primitiveColumn instanceof String);
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new ProfileNameConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var converter = new ProfileNameConverter();
        var faker = FakerService.create();
        var column = converter.convertToEntityAttribute(
            faker.name().firstName()
        );
        assertTrue(column instanceof ProfileName);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new ProfileNameConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
}
