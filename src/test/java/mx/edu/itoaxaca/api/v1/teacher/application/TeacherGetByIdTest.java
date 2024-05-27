package mx.edu.itoaxaca.api.v1.teacher.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.teacher.domain.Teacher;
import mx.edu.itoaxaca.api.v1.teacher.domain.TeacherMother;
import mx.edu.itoaxaca.api.v1.teacher.infrastructure.persistence.TeacherRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TeacherGetByIdTest {
    @Test
    void runTest() {
        var creator = new TeacherGetById();
        var repo = TeacherRepositoryMock.mock();

        Teacher teacher = TeacherMother.random();
        Mockito.when(repo.findTeacherById(teacher.getId())).thenReturn(teacher);
        Teacher teacherFinded = TeacherGetById.run(repo, teacher.getId());

        assertEquals(teacher.getId(), teacherFinded.getId()); 
    }
}
