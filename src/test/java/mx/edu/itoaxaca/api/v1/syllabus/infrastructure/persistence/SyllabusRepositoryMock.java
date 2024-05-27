package mx.edu.itoaxaca.api.v1.syllabus.infrastructure.persistence;

import org.mockito.Mockito;

import mx.edu.itoaxaca.api.v1.syllabus.domain.SyllabusRepository;

public class SyllabusRepositoryMock {

    public static SyllabusRepository mock(){
        return Mockito.mock(SyllabusRepository.class);
    }
}
