package mx.edu.itoaxaca.api.v1.support_staff.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaff;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaffMother;
import mx.edu.itoaxaca.api.v1.support_staff.infrastructure.persistence.SupportStaffRepositoryMock;

public class SupportStaffUpdateTest {
    @Test
    void runTest() {
        var creator = new SupportStaffUpdate();
        var repo = SupportStaffRepositoryMock.mock();

        SupportStaff support_staff = SupportStaffMother.random();
        Mockito.when(repo.save(support_staff)).thenReturn(support_staff);
        SupportStaff support_staffUpdated = SupportStaffUpdate.run(repo, support_staff.getId(), support_staff);

        assertEquals(support_staff, support_staffUpdated); 
    }
}
