package mx.edu.itoaxaca.api.v1.support_staff.infrastructure.controllers;

import java.util.HashMap;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.RestClientTest;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaffMother;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaffRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(SupportStaffController.class)
public class SupportStaffControllerTest
    extends RestClientTest<SupportStaffRepository> {

    @Test
    void testDestroy() throws Exception {
        var support_staff = SupportStaffMother.random();
        Mockito.when(
            this.getRepo().findSupportStaffById(support_staff.getId())
        ).thenReturn(support_staff);
        var url =
            Routes.API_V1_SUPPORT_STAFF_BASE +
            "/" +
            support_staff.getId().toString();
        this.delete(url).andExpect(
                MockMvcResultMatchers.status().isNoContent()
            );
    }

    @Test
    void testIndex() throws Exception {
        this.get(Routes.API_V1_SUPPORT_STAFF_BASE).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testShow() throws Exception {
        var support_staff = SupportStaffMother.random();
        Mockito.when(
            this.getRepo().findSupportStaffById(support_staff.getId())
        ).thenReturn(support_staff);

        var url =
            Routes.API_V1_SUPPORT_STAFF_BASE +
            "/" +
            support_staff.getId().toString();

        this.get(url).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testStore() throws Exception {
        var support_staff = SupportStaffMother.random();
        var request = new HashMap<String, String>();
        request.put("job_title", support_staff.getJobTitle().getValue());
        request.put(
            "support_area_id",
            support_staff.getSupportArea().getId().toString()
        );
        request.put(
            "profile_id",
            support_staff.getProfile().getId().toString()
        );

        this.post(Routes.API_V1_SUPPORT_STAFF_BASE, request).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testUpdate() throws Exception {
        var support_staff = SupportStaffMother.random();
        var support_staffUpdate = SupportStaffMother.random();

        var request = new HashMap<String, String>();
        request.put("jobTitle", support_staffUpdate.getJobTitle().getValue());
        request.put(
            "support_area_id",
            support_staffUpdate.getSupportArea().getId().toString()
        );
        request.put(
            "profile_id",
            support_staffUpdate.getProfile().getId().toString()
        );
        Mockito.when(
            this.getRepo().findSupportStaffById(support_staff.getId())
        ).thenReturn(support_staffUpdate);

        var url =
            Routes.API_V1_SUPPORT_STAFF_BASE +
            "/" +
            support_staff.getId().toString();
        this.put(url, request).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
