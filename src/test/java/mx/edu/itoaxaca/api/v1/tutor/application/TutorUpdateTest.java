package mx.edu.itoaxaca.api.v1.tutor.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.tutor.domain.Tutor;
import mx.edu.itoaxaca.api.v1.tutor.domain.TutorMother;
import mx.edu.itoaxaca.api.v1.tutor.infrastructure.persistence.TutorRepositoryMock;

public class TutorUpdateTest {
    @Test
    void runTest() {
        var creator = new TutorUpdate();
        var repo = TutorRepositoryMock.mock();

        Tutor tutor = TutorMother.random();
        Mockito.when(repo.save(tutor)).thenReturn(tutor);
        Tutor tutorUpdated = TutorUpdate.run(repo, tutor.getId(), tutor);

        assertEquals(tutor.getId(), tutorUpdated.getId()); 
    }
}
