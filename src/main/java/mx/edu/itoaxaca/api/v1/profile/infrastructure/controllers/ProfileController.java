package mx.edu.itoaxaca.api.v1.profile.infrastructure.controllers;

import jakarta.validation.Valid;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.profile.application.ProfileCreate;
import mx.edu.itoaxaca.api.v1.profile.application.ProfileDestroy;
import mx.edu.itoaxaca.api.v1.profile.application.ProfileGetAll;
import mx.edu.itoaxaca.api.v1.profile.application.ProfileGetById;
import mx.edu.itoaxaca.api.v1.profile.application.ProfileUpdate;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileIndexRequest;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileRepository;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileStoreRequest;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileUpdateRequest;
import mx.edu.itoaxaca.api.v1.shared.Config;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Routes.API_V1_PROFILE_BASE)
@RequiredArgsConstructor
@CrossOrigin(value = Config.BASE_URL_FRONTED)
public class ProfileController {

    private final ProfileRepository repo;

    @GetMapping
    Page<Profile> index(@Valid ProfileIndexRequest searchParams) {
        return ProfileGetAll.run(
            repo,
            searchParams.asCriteria()
        );
    }

    @GetMapping(value = "/{id}")
    Profile show(@PathVariable UUID id) {
        return ProfileGetById.run(repo, id);
    }

    @PostMapping
    Profile store(@Valid @RequestBody ProfileStoreRequest request) {
        return ProfileCreate.run(repo, request.asProfile());
    }

    @PutMapping(value = "/{id}")
    Profile update(
        @PathVariable UUID id,
        @Valid @RequestBody ProfileUpdateRequest request
    ) {
        return ProfileUpdate.run(repo, id, request.asProfile());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        ProfileDestroy.run(repo, id);
    }
}
