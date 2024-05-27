package mx.edu.itoaxaca.api.v1.support_staff.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaff;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaffMother;
import mx.edu.itoaxaca.api.v1.support_staff.infrastructure.persistence.SupportStaffRepositoryMock;

public class SupportStaffCreateTest {

    @Test
    void runTest() {
        var creator = new SupportStaffCreate();
        
        var support_staff = SupportStaffMother.random();
        var repo = SupportStaffRepositoryMock.mock();
        Mockito.when(repo.save(support_staff)).thenReturn(support_staff);
    
        SupportStaff support_staffCreated = SupportStaffCreate.run(repo, support_staff);
    }
}
