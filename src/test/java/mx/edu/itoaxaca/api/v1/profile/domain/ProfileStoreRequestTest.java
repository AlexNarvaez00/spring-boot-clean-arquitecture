package mx.edu.itoaxaca.api.v1.profile.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProfileStoreRequestTest {

    @Test
    void testAsProfile() {
        Profile profile = ProfileMother.random();
        var request = new ProfileStoreRequest();
        request.setName(profile.getName().getValue());
        request.setPassword(profile.getPassword().getValue());
        request.setEmail(profile.getEmail().getValue());

        var profileFromReq = request.asProfile();

        assertEquals(
            profileFromReq.getName().getValue(),
            profile.getName().getValue()
        );

        assertEquals(
            profileFromReq.getEmail().getValue(),
            profile.getEmail().getValue()
        );

        assertEquals(
            profileFromReq.getPassword().getValue(),
            profile.getPassword().getValue()
        );
    }
}
