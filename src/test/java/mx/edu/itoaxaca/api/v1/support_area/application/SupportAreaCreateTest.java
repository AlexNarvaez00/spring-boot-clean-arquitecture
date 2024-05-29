package mx.edu.itoaxaca.api.v1.support_area.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.support_area.domain.SupportArea;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportAreaMother;
import mx.edu.itoaxaca.api.v1.support_area.infrastructure.persistence.SupportAreaRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SupportAreaCreateTest {

    @Test
    void runTest() {
        var creator = new SupportAreaCreate();

        var support_area = SupportAreaMother.random();
        var repo = SupportAreaRepositoryMock.mock();
        Mockito.when(repo.save(support_area)).thenReturn(support_area);

        SupportArea support_areaCreated = SupportAreaCreate.run(
            repo,
            support_area
        );
        assertEquals(
            support_area.getName().getValue(),
            support_areaCreated.getName().getValue()
        );
    }
}
