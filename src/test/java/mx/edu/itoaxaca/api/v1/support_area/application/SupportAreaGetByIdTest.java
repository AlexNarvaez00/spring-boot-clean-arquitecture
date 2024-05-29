package mx.edu.itoaxaca.api.v1.support_area.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.support_area.domain.SupportArea;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportAreaMother;
import mx.edu.itoaxaca.api.v1.support_area.infrastructure.persistence.SupportAreaRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SupportAreaGetByIdTest {
    @Test
    void runTest() {
        var creator = new SupportAreaGetById();
        var repo = SupportAreaRepositoryMock.mock();

        SupportArea support_area = SupportAreaMother.random();
        Mockito.when(repo.findSupportAreaById(support_area.getId())).thenReturn(support_area);
        SupportArea support_areaFinded = SupportAreaGetById.run(repo, support_area.getId());

        assertEquals(support_area.getId(), support_areaFinded.getId()); 
    }
}
