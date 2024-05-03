package mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.application.ActivityInstitutionalMentoringProgramCreate;
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.application.ActivityInstitutionalMentoringProgramDestroy;
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.application.ActivityInstitutionalMentoringProgramGetAll;
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.application.ActivityInstitutionalMentoringProgramGetById;
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.application.ActivityInstitutionalMentoringProgramUpdate;
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain.ActivityInstitutionalMentoringProgram;
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain.ActivityInstitutionalMentoringProgramRepository;
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain.ActivityInstitutionalMentoringProgramStoreRequest;
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain.ActivityInstitutionalMentoringProgramUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
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
@RequestMapping(value = Routes.API_V1_ACTIVITY_INSTITUTIONAL_MENTORING_PROGRAM_BASE)
@RequiredArgsConstructor
public class ActivityInstitutionalMentoringProgramController {

    private final ActivityInstitutionalMentoringProgramRepository repo;

    @GetMapping
    Page<ActivityInstitutionalMentoringProgram> index() {
        return ActivityInstitutionalMentoringProgramGetAll.run(
            PageRequest.of(0, 10),
            repo
        );
    }

    @GetMapping(value = "/{id}")
    ActivityInstitutionalMentoringProgram show(@PathVariable UUID id) {
        return ActivityInstitutionalMentoringProgramGetById.run(repo, id);
    }

    @PostMapping
    ActivityInstitutionalMentoringProgram store(
        @Valid @RequestBody ActivityInstitutionalMentoringProgramStoreRequest request
    ) {
        return ActivityInstitutionalMentoringProgramCreate.run(
            repo,
            request.asActivityInstitutionalMentoringProgram()
        );
    }

    @PutMapping(value = "/{id}")
    ActivityInstitutionalMentoringProgram update(
        @PathVariable UUID id,
        @Valid @RequestBody ActivityInstitutionalMentoringProgramUpdateRequest request
    ) {
        return ActivityInstitutionalMentoringProgramUpdate.run(
            repo,
            id,
            request.asActivityInstitutionalMentoringProgram()
        );
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        ActivityInstitutionalMentoringProgramDestroy.run(repo, id);
    }
}
