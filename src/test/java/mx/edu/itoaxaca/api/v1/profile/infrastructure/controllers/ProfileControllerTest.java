package mx.edu.itoaxaca.api.v1.profile.infrastructure.controllers;

import java.util.HashMap;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileMother;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileRepository;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.RestClientTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ProfileController.class)
public class ProfileControllerTest extends RestClientTest<ProfileRepository> {

    @Test
    void testDestroy() throws Exception {
        var profile = ProfileMother.random();
        Mockito.when(
            this.getRepo().findProfileById(profile.getId())
        ).thenReturn(profile);
        var url = Routes.API_V1_PROFILE_BASE + "/" + profile.getId().toString();
        this.delete(url).andExpect(
                MockMvcResultMatchers.status().isNoContent()
            );
    }

    @Test
    void testIndex() throws Exception {
        this.get(Routes.API_V1_PROFILE_BASE).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testShow() throws Exception {
        var profile = ProfileMother.random();
        Mockito.when(
            this.getRepo().findProfileById(profile.getId())
        ).thenReturn(profile);

        var url = Routes.API_V1_PROFILE_BASE + "/" + profile.getId().toString();

        this.get(url).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testStore() throws Exception {
        var profile = ProfileMother.random();
        var request = new HashMap<String, String>();
        request.put("name", profile.getName().getValue());
        request.put("email", profile.getEmail().getValue());
        request.put("password", profile.getPassword().getValue());

        this.post(Routes.API_V1_PROFILE_BASE, request).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testUpdate() throws Exception {
        var profile = ProfileMother.random();
        var profileUpdate = ProfileMother.random();
        
        var request = new HashMap<String, String>();
        request.put("name", profileUpdate.getName().getValue());
        request.put("email", profileUpdate.getEmail().getValue());
        request.put("password", profileUpdate.getPassword().getValue());
        
        Mockito.when(
            this.getRepo().findProfileById(profile.getId())
        ).thenReturn(profileUpdate);

        var url = Routes.API_V1_PROFILE_BASE + "/" + profile.getId().toString();
        this.put(url, request).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
