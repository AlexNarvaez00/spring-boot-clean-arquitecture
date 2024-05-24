package mx.edu.itoaxaca.api.v1.type_date.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDate;
import mx.edu.itoaxaca.api.v1.type_date.infrastructure.persistence.TypeDateRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class TypeDateGetAllTest {
    @Test
    void runTest() {
        var creator = new TypeDateGetAll();

        var repo = TypeDateRepositoryMock.mock();

        PageRequest pageReq = PageRequest.of(0, 2);
        Page<TypeDate> type_dates = new PageImpl<TypeDate>(new ArrayList<TypeDate>(), pageReq, 0);

        Mockito.when(repo.findAll(pageReq)).thenReturn(type_dates);
        Page<TypeDate> all = TypeDateGetAll.run(pageReq, repo);
        assertEquals(all.getSize(), 2);
    }
}
