package mx.edu.itoaxaca.api.v1.teacher.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.teacher.application.TeacherCreate;
import mx.edu.itoaxaca.api.v1.teacher.application.TeacherDestroy;
import mx.edu.itoaxaca.api.v1.teacher.application.TeacherGetAll;
import mx.edu.itoaxaca.api.v1.teacher.application.TeacherGetById;
import mx.edu.itoaxaca.api.v1.teacher.application.TeacherUpdate;
import mx.edu.itoaxaca.api.v1.teacher.domain.Teacher;
import mx.edu.itoaxaca.api.v1.teacher.domain.TeacherRepository;
import mx.edu.itoaxaca.api.v1.teacher.domain.TeacherStoreRequest;
import mx.edu.itoaxaca.api.v1.teacher.domain.TeacherUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_TEACHER_BASE)
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherRepository repo;

    @GetMapping
    Page<Teacher> index() {
        return TeacherGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    Teacher show(@PathVariable UUID id) {
        return TeacherGetById.run(repo, id);
    }

    @PostMapping
    Teacher store(@Valid @RequestBody TeacherStoreRequest request) {
        return TeacherCreate.run(repo, request.asTeacher());
    }

    @PutMapping(value = "/{id}")
    Teacher update(
        @PathVariable UUID id,
        @Valid @RequestBody TeacherUpdateRequest request
    ) {
        return TeacherUpdate.run(repo, id, request.asTeacher());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        TeacherDestroy.run(repo, id);
    }
}
