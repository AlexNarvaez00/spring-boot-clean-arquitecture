package mx.edu.itoaxaca.api.v1.type_support_area.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportArea;
import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.TypeSupportAreaRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class TypeSupportAreaGetAllTest {
    @Test
    void runTest() {
        var creator = new TypeSupportAreaGetAll();

        var repo = TypeSupportAreaRepositoryMock.mock();

        PageRequest pageReq = PageRequest.of(0, 2);
        Page<TypeSupportArea> type_support_areas = new PageImpl<TypeSupportArea>(new ArrayList<TypeSupportArea>(), pageReq, 0);

        Mockito.when(repo.findAll(pageReq)).thenReturn(type_support_areas);
        Page<TypeSupportArea> all = TypeSupportAreaGetAll.run(pageReq, repo);
        assertEquals(all.getSize(), 2);
    }
}
