package mx.edu.itoaxaca.api.v1.profile.domain;

import mx.edu.itoaxaca.api.v1.shared.domain.EmailMother;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ProfileEmailConverterTest {

    @Test
    void testConvertToDatabaseColumn() {
        Profile profile = ProfileMother.random();
        var converter = new ProfileEmailConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(
            new ProfileEmail(EmailMother.random())
        );
        assertTrue(primitiveColumn instanceof String);
    }
    
    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        Profile profile = ProfileMother.random();
        var converter = new ProfileEmailConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }
    
    @Test
    void testConvertToEntityAttribute() {
        var converter = new ProfileEmailConverter();
        var column = converter.convertToEntityAttribute(
           EmailMother.random() 
        );
        assertTrue(column instanceof ProfileEmail);
    }

    @Test
    void testConvertToEntityAttributeWithValueNull() {
        var converter = new ProfileEmailConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
}
