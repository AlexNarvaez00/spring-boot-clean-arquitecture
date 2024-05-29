package mx.edu.itoaxaca.api.v1.support_area.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.support_area.domain.SupportArea;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportAreaMother;
import mx.edu.itoaxaca.api.v1.support_area.infrastructure.persistence.SupportAreaRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SupportAreaUpdateTest {

    @Test
    void runTest() {
        var creator = new SupportAreaUpdate();
        var repo = SupportAreaRepositoryMock.mock();

        SupportArea support_area = SupportAreaMother.random();
        Mockito.when(repo.save(support_area)).thenReturn(support_area);
        SupportArea support_areaUpdated = SupportAreaUpdate.run(
            repo,
            support_area.getId(),
            support_area
        );

        assertEquals(
            support_area.getShortName().getValue(),
            support_areaUpdated.getShortName().getValue()
        );
    }
}
