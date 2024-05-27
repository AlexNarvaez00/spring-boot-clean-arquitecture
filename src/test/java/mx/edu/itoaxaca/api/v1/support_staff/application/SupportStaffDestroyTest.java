package mx.edu.itoaxaca.api.v1.support_staff.application;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaff;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaffMother;
import mx.edu.itoaxaca.api.v1.support_staff.infrastructure.persistence.SupportStaffRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SupportStaffDestroyTest {

    @Test
    void runTest() {
        var destroyer = new SupportStaffDestroy();

        SupportStaff support_staff = SupportStaffMother.random();

        var repo = SupportStaffRepositoryMock.mock();
        Mockito.when(repo.findSupportStaffById(support_staff.getId())).thenReturn(support_staff);

        Mockito.doNothing().when(repo).deleteById(support_staff.getId());
        SupportStaffDestroy.run(repo, support_staff.getId());

        verify(repo, times(1)).deleteById(support_staff.getId());
    }
}
