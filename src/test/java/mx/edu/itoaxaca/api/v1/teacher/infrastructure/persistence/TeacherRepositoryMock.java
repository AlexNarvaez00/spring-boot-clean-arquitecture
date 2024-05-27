package mx.edu.itoaxaca.api.v1.teacher.infrastructure.persistence;

import org.mockito.Mockito;

import mx.edu.itoaxaca.api.v1.teacher.domain.TeacherRepository;

public class TeacherRepositoryMock {

    public static TeacherRepository mock(){
        return Mockito.mock(TeacherRepository.class);
    }
}
