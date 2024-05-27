package mx.edu.itoaxaca.api.v1.syllabus.application;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import mx.edu.itoaxaca.api.v1.syllabus.domain.Syllabus;
import mx.edu.itoaxaca.api.v1.syllabus.domain.SyllabusMother;
import mx.edu.itoaxaca.api.v1.syllabus.infrastructure.persistence.SyllabusRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SyllabusDestroyTest {

    @Test
    void runTest() {
        var destroyer = new SyllabusDelete();

        Syllabus syllabus = SyllabusMother.random();

        var repo = SyllabusRepositoryMock.mock();
        Mockito.when(repo.findSyllabusById(syllabus.getId())).thenReturn(
            syllabus
        );

        Mockito.doNothing().when(repo).deleteById(syllabus.getId());
        SyllabusDelete.run(repo, syllabus.getId());

        verify(repo, times(1)).deleteById(syllabus.getId());
    }
}
