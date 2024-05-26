package mx.edu.itoaxaca.api.v1.tutor.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.tutor.domain.Tutor;
import mx.edu.itoaxaca.api.v1.tutor.domain.TutorMother;
import mx.edu.itoaxaca.api.v1.tutor.infrastructure.persistence.TutorRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TutorGetByIdTest {
    @Test
    void runTest() {
        var creator = new TutorGetById();
        var repo = TutorRepositoryMock.mock();

        Tutor tutor = TutorMother.random();
        Mockito.when(repo.findTutorById(tutor.getId())).thenReturn(tutor);
        Tutor tutorFinded = TutorGetById.run(repo, tutor.getId());

        assertEquals(tutor.getId(), tutorFinded.getId()); 
    }
}
