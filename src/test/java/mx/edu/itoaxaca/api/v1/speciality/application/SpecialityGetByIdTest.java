package mx.edu.itoaxaca.api.v1.speciality.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.speciality.domain.Speciality;
import mx.edu.itoaxaca.api.v1.speciality.domain.SpecialityMother;
import mx.edu.itoaxaca.api.v1.speciality.infrastructure.persistence.SpecialityRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SpecialityGetByIdTest {
    @Test
    void runTest() {
        var creator = new SpecialityGetById();
        var repo = SpecialityRepositoryMock.mock();

        Speciality speciality = SpecialityMother.random();
        Mockito.when(repo.findSpecialityById(speciality.getId())).thenReturn(speciality);
        Speciality specialityFinded = SpecialityGetById.run(repo, speciality.getId());

        assertEquals(speciality.getId(), specialityFinded.getId()); 
    }
}
