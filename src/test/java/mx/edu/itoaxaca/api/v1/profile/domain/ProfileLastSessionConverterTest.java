package mx.edu.itoaxaca.api.v1.profile.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class ProfileLastSessionConverterTest {

    @Test
    void testConvertToDatabaseColumn() {
        var converter = new ProfileLastSessionConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(
            new ProfileLastSession(LocalDateTime.now())
        );
        assertTrue(primitiveColumn instanceof LocalDateTime);
    }

    @Test
    void testConvertToDatabaseColumnWithValueNull() {
        var converter = new ProfileLastSessionConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var converter = new ProfileLastSessionConverter();
        var column = converter.convertToEntityAttribute(LocalDateTime.now());
        assertTrue(column instanceof ProfileLastSession);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new ProfileLastSessionConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
}
