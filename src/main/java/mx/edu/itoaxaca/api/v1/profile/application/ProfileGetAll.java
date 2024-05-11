package mx.edu.itoaxaca.api.v1.profile.application;

import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProfileGetAll {
    public static Page<Profile> run(Pageable pageable, ProfileRepository repo) {
        return repo.findAll(pageable);
    }
}
