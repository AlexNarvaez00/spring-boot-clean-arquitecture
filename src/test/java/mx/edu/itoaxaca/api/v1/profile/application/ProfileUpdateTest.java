package mx.edu.itoaxaca.api.v1.profile.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileMother;
import mx.edu.itoaxaca.api.v1.profile.infrastructure.persistence.ProfileRepositoryMock;

public class ProfileUpdateTest {
    @Test
    void runTest() {
        var creator = new ProfileUpdate();
        var repo = ProfileRepositoryMock.mock();

        Profile profile = ProfileMother.random();
        Mockito.when(repo.save(profile)).thenReturn(profile);
        Profile profileUpdated = ProfileUpdate.run(repo, profile.getId(), profile);

        assertEquals(profile, profileUpdated); 
    }
}
