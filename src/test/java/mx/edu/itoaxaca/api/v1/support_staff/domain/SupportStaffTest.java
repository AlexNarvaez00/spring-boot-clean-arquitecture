package mx.edu.itoaxaca.api.v1.support_staff.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestampsTest;
import org.junit.jupiter.api.Test;

public class SupportStaffTest {

    @Test
    void testCreateSupportStaff() {
        SupportStaff temp = SupportStaffMother.random();
        assertNotNull(temp.getId());
    }

    @Test
    void testCreateSupportStaffWithNullValue() {
        SupportStaff temp = new SupportStaff();
        assertNull(temp.getId());
    }

    @Test
    void testCompareSupportStaff() {
        SupportStaff temp = SupportStaffMother.random();
        SupportStaff temp2 = temp;
        assertTrue(temp.equals(temp2));
        assertInstanceOf(Integer.class, temp2.hashCode());
    }

    @Test
    void testToString() {
        SupportStaff support_staff = SupportStaffMother.random();
        assertTrue(support_staff.toString().contains(support_staff.getId().toString()));
    }

    @Test
    void testNotCompareSupportStaff() {
        SupportStaff temp = SupportStaffMother.random();
        SupportStaff temp2 = SupportStaffMother.random();
        assertFalse(temp.equals(temp2));
    }

    @Test
    void testSettingValues() {
        SupportStaff support_staff = new SupportStaff();

        UUID uuid = UUID.randomUUID();
        support_staff.setId(uuid);
        assertInstanceOf(UUID.class, support_staff.getId());
    }

    @Test
    void testTimestamps() {
        SupportStaff support_staff = SupportStaffMother.random();
        var support_staffAssert = new WithTimestampsTest<SupportStaff>();
        support_staffAssert.assertWithTimestamp(support_staff);

        SupportStaff support_staff2 = support_staff;
        support_staffAssert.assertEqualsTimestamps(support_staff, support_staff2);
    }

}
