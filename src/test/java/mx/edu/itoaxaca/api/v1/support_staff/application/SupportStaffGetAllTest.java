package mx.edu.itoaxaca.api.v1.support_staff.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaff;
import mx.edu.itoaxaca.api.v1.support_staff.infrastructure.persistence.SupportStaffRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class SupportStaffGetAllTest {
    @Test
    void runTest() {
        var creator = new SupportStaffGetAll();

        var repo = SupportStaffRepositoryMock.mock();

        PageRequest pageReq = PageRequest.of(0, 2);
        Page<SupportStaff> support_staffs = new PageImpl<SupportStaff>(new ArrayList<SupportStaff>(), pageReq, 0);

        Mockito.when(repo.findAll(pageReq)).thenReturn(support_staffs);
        Page<SupportStaff> all = SupportStaffGetAll.run(pageReq, repo);
        assertEquals(all.getSize(), 2);
    }
}
