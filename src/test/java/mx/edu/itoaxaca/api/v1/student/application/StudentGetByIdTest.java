package mx.edu.itoaxaca.api.v1.student.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.student.domain.Student;
import mx.edu.itoaxaca.api.v1.student.domain.StudentMother;
import mx.edu.itoaxaca.api.v1.student.infrastructure.persistence.StudentRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StudentGetByIdTest {
    @Test
    void runTest() {
        var creator = new StudentGetById();
        var repo = StudentRepositoryMock.mock();

        Student student = StudentMother.random();
        Mockito.when(repo.findStudentById(student.getId())).thenReturn(student);
        Student studentFinded = StudentGetById.run(repo, student.getId());

        assertEquals(student.getId(), studentFinded.getId()); 
    }
}
