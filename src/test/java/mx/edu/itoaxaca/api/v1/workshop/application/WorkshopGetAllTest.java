package mx.edu.itoaxaca.api.v1.workshop.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import mx.edu.itoaxaca.api.v1.workshop.domain.Workshop;
import mx.edu.itoaxaca.api.v1.workshop.infrastructure.persistence.WorkshopRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class WorkshopGetAllTest {
    @Test
    void runTest() {
        var creator = new WorkshopGretAll();

        var repo = WorkshopRepositoryMock.mock();

        PageRequest pageReq = PageRequest.of(0, 2);
        Page<Workshop> workshops = new PageImpl<Workshop>(new ArrayList<Workshop>(), pageReq, 0);

        Mockito.when(repo.findAll(pageReq)).thenReturn(workshops);
        Page<Workshop> all = WorkshopGretAll.run(pageReq, repo);
        assertEquals(all.getSize(), 2);
    }
}
