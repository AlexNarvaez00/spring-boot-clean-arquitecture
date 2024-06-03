package mx.edu.itoaxaca.api.v1.speciality.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import mx.edu.itoaxaca.api.v1.speciality.domain.Speciality;
import mx.edu.itoaxaca.api.v1.speciality.domain.SpecialityMother;
import mx.edu.itoaxaca.api.v1.speciality.infrastructure.persistence.SpecialityRepositoryMock;

public class SpecialityCreateTest {

    @Test
    void runTest() {
        var creator = new SpecialityCreate();
        
        var speciality = SpecialityMother.random();
        var repo = SpecialityRepositoryMock.mock();
        Mockito.when(repo.save(speciality)).thenReturn(speciality);
    
        Speciality specialityCreated = SpecialityCreate.run(repo, speciality);

        assertEquals(speciality.getCode().getValue(), specialityCreated.getCode().getValue());

    }
}
