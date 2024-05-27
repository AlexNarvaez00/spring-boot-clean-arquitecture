package mx.edu.itoaxaca.api.v1.teacher.application;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import mx.edu.itoaxaca.api.v1.teacher.domain.Teacher;
import mx.edu.itoaxaca.api.v1.teacher.domain.TeacherMother;
import mx.edu.itoaxaca.api.v1.teacher.infrastructure.persistence.TeacherRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TeacherDestroyTest {

    @Test
    void runTest() {
        var destroyer = new TeacherDestroy();

        Teacher teacher = TeacherMother.random();

        var repo = TeacherRepositoryMock.mock();
        Mockito.when(repo.findTeacherById(teacher.getId())).thenReturn(teacher);

        Mockito.doNothing().when(repo).deleteById(teacher.getId());
        TeacherDestroy.run(repo, teacher.getId());

        verify(repo, times(1)).deleteById(teacher.getId());
    }
}
