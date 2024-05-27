package mx.edu.itoaxaca.api.v1.syllabus.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.syllabus.domain.Syllabus;
import mx.edu.itoaxaca.api.v1.syllabus.domain.SyllabusMother;
import mx.edu.itoaxaca.api.v1.syllabus.infrastructure.persistence.SyllabusRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SyllabusGetByIdTest {
    @Test
    void runTest() {
        var creator = new SyllabusGetById();
        var repo = SyllabusRepositoryMock.mock();

        Syllabus syllabus = SyllabusMother.random();
        Mockito.when(repo.findSyllabusById(syllabus.getId())).thenReturn(syllabus);
        Syllabus syllabusFinded = SyllabusGetById.run(repo, syllabus.getId());

        assertEquals(syllabus.getId(), syllabusFinded.getId()); 
    }
}
