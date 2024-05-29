package mx.edu.itoaxaca.api.v1.support_staff.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SupportStaffUpdateRequestTest {
    @Test
    void testAsSupportStaff() {
        SupportStaff support_staff = SupportStaffMother.random();
        var request = new SupportStaffUpdateRequest();
        request.setJobTitle(support_staff.getJobTitle().getValue());
        var support_staffFromReq = request.asSupportStaff();
        assertEquals(
            support_staff.getJobTitle().getValue(),
            support_staffFromReq.getJobTitle().getValue()
        );
    }
   
}
