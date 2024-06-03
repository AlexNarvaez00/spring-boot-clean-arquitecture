package mx.edu.itoaxaca.api.v1.speciality.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestampsTest;
import org.junit.jupiter.api.Test;

public class SpecialityTest {

    @Test
    void testCreateSpeciality() {
        Speciality temp = SpecialityMother.random();
        assertNotNull(temp.getId());
    }

    @Test
    void testCreateSpecialityWithNullValue() {
        Speciality temp = new Speciality();
        assertNull(temp.getId());
    }

    @Test
    void testCompareSpeciality() {
        Speciality temp = SpecialityMother.random();
        Speciality temp2 = temp;
        assertTrue(temp.equals(temp2));
        assertInstanceOf(Integer.class, temp2.hashCode());
    }

    @Test
    void testToString() {
        Speciality speciality = SpecialityMother.random();
        assertTrue(speciality.toString().contains(speciality.getId().toString()));
    }

    @Test
    void testNotCompareSpeciality() {
        Speciality temp = SpecialityMother.random();
        Speciality temp2 = SpecialityMother.random();
        assertFalse(temp.equals(temp2));
    }

    @Test
    void testSettingValues() {
        Speciality speciality = new Speciality();

        UUID uuid = UUID.randomUUID();
        speciality.setId(uuid);
        assertInstanceOf(UUID.class, speciality.getId());
    }

    @Test
    void testTimestamps() {
        Speciality speciality = SpecialityMother.random();
        var specialityAssert = new WithTimestampsTest<Speciality>();
        specialityAssert.assertWithTimestamp(speciality);

        Speciality speciality2 = speciality;
        specialityAssert.assertEqualsTimestamps(speciality, speciality2);
    }

}
