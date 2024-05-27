package mx.edu.itoaxaca.api.v1.syllabus.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import mx.edu.itoaxaca.api.v1.syllabus.domain.Syllabus;
import mx.edu.itoaxaca.api.v1.syllabus.infrastructure.persistence.SyllabusRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class SyllabusGetAllTest {
    @Test
    void runTest() {
        var creator = new SyllabusGetAll();

        var repo = SyllabusRepositoryMock.mock();

        PageRequest pageReq = PageRequest.of(0, 2);
        Page<Syllabus> syllabuss = new PageImpl<Syllabus>(new ArrayList<Syllabus>(), pageReq, 0);

        Mockito.when(repo.findAll(pageReq)).thenReturn(syllabuss);
        Page<Syllabus> all = SyllabusGetAll.run(pageReq, repo);
        assertEquals(all.getSize(), 2);
    }
}
