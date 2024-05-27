package mx.edu.itoaxaca.api.v1.support_staff.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SupportStaffStoreRequestTest {

    @Test
    void testAsSupportStaff() {
        SupportStaff support_staff = SupportStaffMother.random();
        var request = new SupportStaffStoreRequest();

        var support_staffFromReq = request.asSupportStaff();

        assertEquals();
        assertEquals();
    } 
}
