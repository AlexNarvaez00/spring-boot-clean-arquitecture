package mx.edu.itoaxaca.api.v1.institutional_mentoring_program.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.application.InstitutionalMentoringProgramCreate;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.application.InstitutionalMentoringProgramDestroy;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.application.InstitutionalMentoringProgramGetAll;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.application.InstitutionalMentoringProgramGetById;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.application.InstitutionalMentoringProgramUpdate;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain.InstitutionalMentoringProgram;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain.InstitutionalMentoringProgramRepository;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain.InstitutionalMentoringProgramStoreRequest;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain.InstitutionalMentoringProgramUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_INSTITUTIONAL_MENTORING_PROGRAM_BASE)
@RequiredArgsConstructor
public class InstitutionalMentoringProgramController {

    private final InstitutionalMentoringProgramRepository repo;

    @GetMapping
    Page<InstitutionalMentoringProgram> index() {
        return InstitutionalMentoringProgramGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    InstitutionalMentoringProgram show(@PathVariable UUID id) {
        return InstitutionalMentoringProgramGetById.run(repo, id);
    }

    @PostMapping
    InstitutionalMentoringProgram store(
        @Valid @RequestBody InstitutionalMentoringProgramStoreRequest request
    ) {
        return InstitutionalMentoringProgramCreate.run(
            repo,
            request.asInstitutionalMentoringProgram()
        );
    }

    @PutMapping(value = "/{id}")
    InstitutionalMentoringProgram update(
        @PathVariable UUID id,
        @Valid @RequestBody InstitutionalMentoringProgramUpdateRequest request
    ) {
        return InstitutionalMentoringProgramUpdate.run(
            repo,
            id,
            request.asInstitutionalMentoringProgram()
        );
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        InstitutionalMentoringProgramDestroy.run(repo, id);
    }
}
