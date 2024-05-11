package mx.edu.itoaxaca.api.v1.profile.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileRepository;

public class ProfileDestroy {
    public static void run(ProfileRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
