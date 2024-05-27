package mx.edu.itoaxaca.api.v1.syllabus.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import mx.edu.itoaxaca.api.v1.syllabus.domain.Syllabus;
import mx.edu.itoaxaca.api.v1.syllabus.domain.SyllabusMother;
import mx.edu.itoaxaca.api.v1.syllabus.infrastructure.persistence.SyllabusRepositoryMock;

public class SyllabusCreateTest {

    @Test
    void runTest() {
        var creator = new SyllabusCreate();
        
        var syllabus = SyllabusMother.random();
        var repo = SyllabusRepositoryMock.mock();
        Mockito.when(repo.save(syllabus)).thenReturn(syllabus);
    
        Syllabus syllabusCreated = SyllabusCreate.run(repo, syllabus);
    }
}
