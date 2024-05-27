package mx.edu.itoaxaca.api.v1.support_staff.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaff;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaffMother;
import mx.edu.itoaxaca.api.v1.support_staff.infrastructure.persistence.SupportStaffRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SupportStaffGetByIdTest {
    @Test
    void runTest() {
        var creator = new SupportStaffGetById();
        var repo = SupportStaffRepositoryMock.mock();

        SupportStaff support_staff = SupportStaffMother.random();
        Mockito.when(repo.findSupportStaffById(support_staff.getId())).thenReturn(support_staff);
        SupportStaff support_staffFinded = SupportStaffGetById.run(repo, support_staff.getId());

        assertEquals(support_staff.getId(), support_staffFinded.getId()); 
    }
}
