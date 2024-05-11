package mx.edu.itoaxaca.api.v1.student.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.student.application.StudentCreate;
import mx.edu.itoaxaca.api.v1.student.application.StudentDestroy;
import mx.edu.itoaxaca.api.v1.student.application.StudentGetAll;
import mx.edu.itoaxaca.api.v1.student.application.StudentGetById;
import mx.edu.itoaxaca.api.v1.student.application.StudentUpdate;
import mx.edu.itoaxaca.api.v1.student.domain.Student;
import mx.edu.itoaxaca.api.v1.student.domain.StudentRepository;
import mx.edu.itoaxaca.api.v1.student.domain.StudentStoreRequest;
import mx.edu.itoaxaca.api.v1.student.domain.StudentUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_STUDENT_BASE)
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository repo;

    @GetMapping
    Page<Student> index() {
        return StudentGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    Student show(@PathVariable UUID id) {
        return StudentGetById.run(repo, id);
    }

    @PostMapping
    Student store(@Valid @RequestBody StudentStoreRequest request) {
        return StudentCreate.run(repo, request.asStudent());
    }

    @PutMapping(value = "/{id}")
    Student update(
        @PathVariable UUID id,
        @Valid @RequestBody StudentUpdateRequest request
    ) {
        return StudentUpdate.run(repo, id, request.asStudent());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        StudentDestroy.run(repo, id);
    }
}
