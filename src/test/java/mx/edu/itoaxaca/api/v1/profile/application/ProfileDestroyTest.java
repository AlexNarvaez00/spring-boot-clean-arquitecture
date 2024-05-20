package mx.edu.itoaxaca.api.v1.profile.application;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileMother;
import mx.edu.itoaxaca.api.v1.profile.infrastructure.persistence.ProfileRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ProfileDestroyTest {

    @Test
    void runTest() {
        var destroyer = new ProfileDestroy();

        Profile profile = ProfileMother.random();

        var repo = ProfileRepositoryMock.mock();
        Mockito.when(repo.findProfileById(profile.getId())).thenReturn(profile);

        Mockito.doNothing().when(repo).deleteById(profile.getId());
        ProfileDestroy.run(repo, profile.getId());

        verify(repo, times(1)).deleteById(profile.getId());
    }
}
