package mx.edu.itoaxaca.api.v1.teacher.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.teacher.domain.Teacher;
import mx.edu.itoaxaca.api.v1.teacher.domain.TeacherMother;
import mx.edu.itoaxaca.api.v1.teacher.infrastructure.persistence.TeacherRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TeacherCreateTest {

    @Test
    void runTest() {
        var creator = new TeacherCreate();

        var teacher = TeacherMother.random();
        var repo = TeacherRepositoryMock.mock();
        Mockito.when(repo.save(teacher)).thenReturn(teacher);

        Teacher teacherCreated = TeacherCreate.run(repo, teacher);

        assertEquals(
            teacher.getType().getValue(),
            teacherCreated.getType().getValue()
        );
    }
}
