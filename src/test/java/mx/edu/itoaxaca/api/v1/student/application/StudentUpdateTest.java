package mx.edu.itoaxaca.api.v1.student.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.student.domain.Student;
import mx.edu.itoaxaca.api.v1.student.domain.StudentMother;
import mx.edu.itoaxaca.api.v1.student.infrastructure.persistence.StudentRepositoryMock;

public class StudentUpdateTest {
    @Test
    void runTest() {
        var creator = new StudentUpdate();
        var repo = StudentRepositoryMock.mock();

        Student student = StudentMother.random();
        Mockito.when(repo.save(student)).thenReturn(student);
        Student studentUpdated = StudentUpdate.run(repo, student.getId(), student);

        assertEquals(student, studentUpdated); 
    }
}
