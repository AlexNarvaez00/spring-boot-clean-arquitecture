package mx.edu.itoaxaca.api.v1.syllabus.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.syllabus.domain.Syllabus;
import mx.edu.itoaxaca.api.v1.syllabus.domain.SyllabusMother;
import mx.edu.itoaxaca.api.v1.syllabus.infrastructure.persistence.SyllabusRepositoryMock;

public class SyllabusUpdateTest {
    @Test
    void runTest() {
        var creator = new SyllabusUpdate();
        var repo = SyllabusRepositoryMock.mock();

        Syllabus syllabus = SyllabusMother.random();
        Mockito.when(repo.save(syllabus)).thenReturn(syllabus);
        Syllabus syllabusUpdated = SyllabusUpdate.run(repo, syllabus.getId(), syllabus);

        assertEquals(syllabus, syllabusUpdated); 
    }
}
