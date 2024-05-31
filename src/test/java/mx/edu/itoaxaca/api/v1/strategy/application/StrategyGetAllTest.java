package mx.edu.itoaxaca.api.v1.strategy.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import mx.edu.itoaxaca.api.v1.strategy.domain.Strategy;
import mx.edu.itoaxaca.api.v1.strategy.infrastructure.persistence.StrategyRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class StrategyGetAllTest {
    @Test
    void runTest() {
        var creator = new StrategyGetAll();

        var repo = StrategyRepositoryMock.mock();

        PageRequest pageReq = PageRequest.of(0, 2);
        Page<Strategy> strategys = new PageImpl<Strategy>(new ArrayList<Strategy>(), pageReq, 0);

        Mockito.when(repo.findAll(pageReq)).thenReturn(strategys);
        Page<Strategy> all = StrategyGetAll.run(pageReq, repo);
        assertEquals(all.getSize(), 2);
    }
}
