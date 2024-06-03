package mx.edu.itoaxaca.api.v1.speciality.application;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import mx.edu.itoaxaca.api.v1.speciality.domain.Speciality;
import mx.edu.itoaxaca.api.v1.speciality.domain.SpecialityMother;
import mx.edu.itoaxaca.api.v1.speciality.infrastructure.persistence.SpecialityRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SpecialityDestroyTest {

    @Test
    void runTest() {
        var destroyer = new SpecialityDestroy();

        Speciality speciality = SpecialityMother.random();

        var repo = SpecialityRepositoryMock.mock();
        Mockito.when(repo.findSpecialityById(speciality.getId())).thenReturn(speciality);

        Mockito.doNothing().when(repo).deleteById(speciality.getId());
        SpecialityDestroy.run(repo, speciality.getId());

        verify(repo, times(1)).deleteById(speciality.getId());
    }
}
