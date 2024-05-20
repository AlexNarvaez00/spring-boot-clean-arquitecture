package mx.edu.itoaxaca.api.v1.period.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import mx.edu.itoaxaca.api.v1.period.domain.Period;
import mx.edu.itoaxaca.api.v1.period.infrastructure.persistence.PeriodRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class PeriodGetAllTest {

    @Test
    void testRun() {
        var creator = new PeriodGetAll();

        var repo = PeriodRepositoryMock.mock();

        PageRequest pageReq = PageRequest.of(0, 2);
        Page<Period> periods = new PageImpl<Period>(new ArrayList<Period>(), pageReq, 0);

        Mockito.when(repo.findByDeletedAtIsNull(pageReq)).thenReturn(periods);
        Page<Period> all = PeriodGetAll.run(pageReq, repo);
        assertEquals(all.getSize(), 2);
    }
}
