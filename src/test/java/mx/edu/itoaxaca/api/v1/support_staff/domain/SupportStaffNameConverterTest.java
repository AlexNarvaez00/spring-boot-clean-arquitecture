package mx.edu.itoaxaca.api.v1.support_staff.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class SupportStaffNameConverterTest {
    
    @Test
    void testConvertToDatabaseColumn() {
        SupportStaff support_staff = SupportStaffMother.random();
        var converter = new SupportStaffNameConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(support_staff.getName());
        assertTrue(primitiveColumn instanceof );
    }

    @Test
    void testConvertToDatabaseColumnWithNullValue() {
        var converter = new SupportStaffNameConverter();
        var primitiveColumn = converter.convertToDatabaseColumn(null);
        assertTrue(primitiveColumn == null);
    }

    @Test
    void testConvertToEntityAttribute() {
        var converter = new SupportStaffNameConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column instanceof SupportStaffName);
    }

    @Test
    void testConvertToEntityAttributeWithNullValue() {
        var converter = new SupportStaffNameConverter();
        var column = converter.convertToEntityAttribute(null);
        assertTrue(column == null);
    }
   
}
