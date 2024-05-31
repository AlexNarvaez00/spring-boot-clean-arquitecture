package mx.edu.itoaxaca.api.v1.student.application;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import mx.edu.itoaxaca.api.v1.student.domain.Student;
import mx.edu.itoaxaca.api.v1.student.domain.StudentMother;
import mx.edu.itoaxaca.api.v1.student.infrastructure.persistence.StudentRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StudentDestroyTest {

    @Test
    void runTest() {
        var destroyer = new StudentDestroy();

        Student student = StudentMother.random();

        var repo = StudentRepositoryMock.mock();
        Mockito.when(repo.findStudentById(student.getId())).thenReturn(student);

        Mockito.doNothing().when(repo).deleteById(student.getId());
        StudentDestroy.run(repo, student.getId());

        verify(repo, times(1)).deleteById(student.getId());
    }
}
