package mx.edu.itoaxaca.api.v1.speciality.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.speciality.domain.Speciality;
import mx.edu.itoaxaca.api.v1.speciality.domain.SpecialityMother;
import mx.edu.itoaxaca.api.v1.speciality.infrastructure.persistence.SpecialityRepositoryMock;

public class SpecialityUpdateTest {
    @Test
    void runTest() {
        var creator = new SpecialityUpdate();
        var repo = SpecialityRepositoryMock.mock();

        Speciality speciality = SpecialityMother.random();
        Mockito.when(repo.save(speciality)).thenReturn(speciality);
        Speciality specialityUpdated = SpecialityUpdate.run(repo, speciality.getId(), speciality);

        assertEquals(speciality, specialityUpdated); 
    }
}
