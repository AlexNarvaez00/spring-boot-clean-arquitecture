package mx.edu.itoaxaca.api.v1.profile.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileRepository;

public class ProfileUpdate {
    public static Profile run(
        ProfileRepository repo,
        UUID id,
        Profile arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
