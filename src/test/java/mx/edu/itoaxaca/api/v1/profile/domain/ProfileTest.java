package mx.edu.itoaxaca.api.v1.profile.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestampsTest;
import org.junit.jupiter.api.Test;

public class ProfileTest {

    @Test
    void testCreateProfile() {
        Profile temp = ProfileMother.random();
        assertNotNull(temp.getId());
        assertNotNull(temp.getName());
        assertNotNull(temp.getPassword());
        assertNull(temp.getLastSession());
        assertNull(temp.getInstitutionalCoordinator());
        assertNull(temp.getDepartament());
        assertNull(temp.getTutor());
        assertNull(temp.getSupportStaff());
        assertNull(temp.getStudent());
        assertNull(temp.getTeacher());
        assertNull(temp.getDepartamentTeacher());
        
        temp.setId(null);
        assertNull(temp.getId());
        temp.setName(null);
        assertNull(temp.getName());
        temp.setPassword(null);
        assertNull(temp.getPassword());
        temp.setLastSession(null);
        assertNull(temp.getLastSession());
        temp.setInstitutionalCoordinator(null);
        assertNull(temp.getInstitutionalCoordinator());
        temp.setDepartament(null);
        assertNull(temp.getDepartament());
        temp.setTutor(null);
        assertNull(temp.getTutor());
        temp.setSupportStaff(null);
        assertNull(temp.getSupportStaff());
        temp.setStudent(null); 
        assertNull(temp.getStudent());
        temp.setTeacher(null);
        assertNull(temp.getTeacher());
        temp.setDepartamentTeacher(null);
        assertNull(temp.getDepartamentTeacher());
    }

    @Test
    void testCreateProfileWithNullValue() {
        Profile temp = new Profile();
        assertNull(temp.getId());
    }

    @Test
    void testCompareProfile() {
        Profile temp = ProfileMother.random();
        Profile temp2 = temp;
        assertTrue(temp.equals(temp2));
        temp.canEqual(temp2);
        assertInstanceOf(Integer.class, temp2.hashCode());
    }

    @Test
    void testToString() {
        Profile profile = ProfileMother.random();
        assertTrue(profile.toString().contains(profile.getId().toString()));
    }

    @Test
    void testNotCompareProfile() {
        Profile temp = ProfileMother.random();
        Profile temp2 = ProfileMother.random();
        assertFalse(temp.equals(temp2));
    }

    @Test
    void testSettingValues() {
        Profile profile = new Profile();

        UUID uuid = UUID.randomUUID();
        profile.setId(uuid);
        assertInstanceOf(UUID.class, profile.getId());
    }

    @Test
    void testTimestamps() {
        Profile profile = ProfileMother.random();
        var profileAssert = new WithTimestampsTest<Profile>();
        profileAssert.assertWithTimestamp(profile);

        Profile profile2 = profile;
        profileAssert.assertEqualsTimestamps(profile, profile2);
    }
}
