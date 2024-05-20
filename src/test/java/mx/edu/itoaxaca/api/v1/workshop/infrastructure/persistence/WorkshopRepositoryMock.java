package mx.edu.itoaxaca.api.v1.workshop.infrastructure.persistence;

import org.mockito.Mockito;

import mx.edu.itoaxaca.api.v1.workshop.domain.WorkshopRepository;

public class WorkshopRepositoryMock {

    public static WorkshopRepository mock(){
        return Mockito.mock(WorkshopRepository.class);
    }
}
