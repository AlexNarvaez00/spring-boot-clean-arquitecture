package mx.edu.itoaxaca.api.v1.profile.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileMother;
import mx.edu.itoaxaca.api.v1.profile.infrastructure.persistence.ProfileRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ProfileCreateTest {

    @Test
    void runTest() {
        var creator = new ProfileCreate();

        var profile = ProfileMother.random();
        var repo = ProfileRepositoryMock.mock();
        Mockito.when(repo.save(profile)).thenReturn(profile);

        Profile profileCreated = ProfileCreate.run(repo, profile);
        assertEquals(profile.getId(), profileCreated.getId());
    }
}
