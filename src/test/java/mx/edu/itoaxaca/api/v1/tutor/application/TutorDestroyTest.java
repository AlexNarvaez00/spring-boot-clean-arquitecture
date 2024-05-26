package mx.edu.itoaxaca.api.v1.tutor.application;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import mx.edu.itoaxaca.api.v1.tutor.domain.Tutor;
import mx.edu.itoaxaca.api.v1.tutor.domain.TutorMother;
import mx.edu.itoaxaca.api.v1.tutor.infrastructure.persistence.TutorRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TutorDestroyTest {

    @Test
    void runTest() {
        var destroyer = new TutorDestroy();

        Tutor tutor = TutorMother.random();

        var repo = TutorRepositoryMock.mock();
        Mockito.when(repo.findTutorById(tutor.getId())).thenReturn(tutor);

        Mockito.doNothing().when(repo).deleteById(tutor.getId());
        TutorDestroy.run(repo, tutor.getId());

        verify(repo, times(1)).deleteById(tutor.getId());
    }
}
