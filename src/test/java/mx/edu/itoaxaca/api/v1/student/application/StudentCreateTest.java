package mx.edu.itoaxaca.api.v1.student.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.student.domain.Student;
import mx.edu.itoaxaca.api.v1.student.domain.StudentMother;
import mx.edu.itoaxaca.api.v1.student.infrastructure.persistence.StudentRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StudentCreateTest {

    @Test
    void runTest() {
        var creator = new StudentCreate();

        var student = StudentMother.random();
        var repo = StudentRepositoryMock.mock();
        Mockito.when(repo.save(student)).thenReturn(student);

        Student studentCreated = StudentCreate.run(repo, student);
        assertEquals(
            student.getControlNumber().getValue(),
            studentCreated.getControlNumber().getValue()
        );
    }
}
