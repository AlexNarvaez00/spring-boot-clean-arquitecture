package mx.edu.itoaxaca.api.v1.student.infrastructure.persistence;

import mx.edu.itoaxaca.api.v1.student.domain.StudentRepository;
import org.mockito.Mockito;

public class StudentRepositoryMock {

    public static StudentRepository mock(){
        return Mockito.mock(StudentRepository.class);
    }
}
