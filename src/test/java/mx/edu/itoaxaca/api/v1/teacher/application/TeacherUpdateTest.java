package mx.edu.itoaxaca.api.v1.teacher.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.teacher.domain.Teacher;
import mx.edu.itoaxaca.api.v1.teacher.domain.TeacherMother;
import mx.edu.itoaxaca.api.v1.teacher.infrastructure.persistence.TeacherRepositoryMock;

public class TeacherUpdateTest {
    @Test
    void runTest() {
        var creator = new TeacherUpdate();
        var repo = TeacherRepositoryMock.mock();

        Teacher teacher = TeacherMother.random();
        Mockito.when(repo.save(teacher)).thenReturn(teacher);
        Teacher teacherUpdated = TeacherUpdate.run(repo, teacher.getId(), teacher);

        assertEquals(teacher, teacherUpdated); 
    }
}
