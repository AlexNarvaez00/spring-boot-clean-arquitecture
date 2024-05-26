package mx.edu.itoaxaca.api.v1.tutor.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import mx.edu.itoaxaca.api.v1.tutor.domain.Tutor;
import mx.edu.itoaxaca.api.v1.tutor.infrastructure.persistence.TutorRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class TutorGetAllTest {
    @Test
    void runTest() {
        var creator = new TutorGetAll();

        var repo = TutorRepositoryMock.mock();

        PageRequest pageReq = PageRequest.of(0, 2);
        Page<Tutor> tutors = new PageImpl<Tutor>(new ArrayList<Tutor>(), pageReq, 0);

        Mockito.when(repo.findAll(pageReq)).thenReturn(tutors);
        Page<Tutor> all = TutorGetAll.run(pageReq, repo);
        assertEquals(all.getSize(), 2);
    }
}
