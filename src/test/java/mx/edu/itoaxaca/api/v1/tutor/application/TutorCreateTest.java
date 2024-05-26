package mx.edu.itoaxaca.api.v1.tutor.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.tutor.domain.Tutor;
import mx.edu.itoaxaca.api.v1.tutor.domain.TutorMother;
import mx.edu.itoaxaca.api.v1.tutor.infrastructure.persistence.TutorRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TutorCreateTest {

    @Test
    void runTest() {
        var creator = new TutorCreate();

        var tutor = TutorMother.random();
        var repo = TutorRepositoryMock.mock();
        Mockito.when(repo.save(tutor)).thenReturn(tutor);

        Tutor tutorCreated = TutorCreate.run(repo, tutor);

        assertEquals(tutor.getId(), tutorCreated.getId());
    }
}
