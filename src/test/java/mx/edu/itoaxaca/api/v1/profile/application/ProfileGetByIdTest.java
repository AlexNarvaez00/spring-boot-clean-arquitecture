package mx.edu.itoaxaca.api.v1.profile.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileMother;
import mx.edu.itoaxaca.api.v1.profile.infrastructure.persistence.ProfileRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ProfileGetByIdTest {
    @Test
    void testRun() {
        var creator = new ProfileGetById();
        var repo = ProfileRepositoryMock.mock();

        Profile profile = ProfileMother.random();
        Mockito.when(repo.findProfileById(profile.getId())).thenReturn(profile);
        Profile profileFinded = ProfileGetById.run(repo, profile.getId());

        assertEquals(profile.getId(), profileFinded.getId()); 
    }
}
