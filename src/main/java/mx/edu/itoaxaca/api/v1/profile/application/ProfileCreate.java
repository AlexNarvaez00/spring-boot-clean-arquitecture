package mx.edu.itoaxaca.api.v1.profile.application;

import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileRepository;

public class ProfileCreate {
    public static Profile run(ProfileRepository repo, Profile arg) {
        return repo.save(arg);
    }
}
