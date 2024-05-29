package mx.edu.itoaxaca.api.v1.support_area.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportArea;
import mx.edu.itoaxaca.api.v1.support_area.infrastructure.persistence.SupportAreaRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class SupportAreaGetAllTest {
    @Test
    void runTest() {
        var creator = new SupportAreaGetAll();

        var repo = SupportAreaRepositoryMock.mock();

        PageRequest pageReq = PageRequest.of(0, 2);
        Page<SupportArea> support_areas = new PageImpl<SupportArea>(new ArrayList<SupportArea>(), pageReq, 0);

        Mockito.when(repo.findAll(pageReq)).thenReturn(support_areas);
        Page<SupportArea> all = SupportAreaGetAll.run(pageReq, repo);
        assertEquals(all.getSize(), 2);
    }
}
