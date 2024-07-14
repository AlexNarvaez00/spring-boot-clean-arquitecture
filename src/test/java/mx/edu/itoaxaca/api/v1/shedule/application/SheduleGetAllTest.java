package mx.edu.itoaxaca.api.v1.shedule.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import mx.edu.itoaxaca.api.v1.shedule.domain.Shedule;
import mx.edu.itoaxaca.api.v1.shedule.infrastructure.persistence.SheduleRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class SheduleGetAllTest {
    @Test
    void runTest() {
        var creator = new SheduleGetAll();

        var repo = SheduleRepositoryMock.mock();

        PageRequest pageReq = PageRequest.of(0, 2);
        Page<Shedule> shedules = new PageImpl<Shedule>(new ArrayList<Shedule>(), pageReq, 0);

        Mockito.when(repo.findAll(pageReq)).thenReturn(shedules);
        Page<Shedule> all = SheduleGetAll.run(pageReq, repo);
        assertEquals(all.getSize(), 2);
    }
}
