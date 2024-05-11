package mx.edu.itoaxaca.api.v1.profile.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileRepository;

public class ProfileGetById {
    public static Profile run(ProfileRepository repo, UUID id) {
        return repo.findProfileById(id);
    }
}
