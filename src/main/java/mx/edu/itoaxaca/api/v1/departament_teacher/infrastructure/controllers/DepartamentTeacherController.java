package mx.edu.itoaxaca.api.v1.departament_teacher.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.departament_teacher.application.DepartamentTeacherCreate;
import mx.edu.itoaxaca.api.v1.departament_teacher.application.DepartamentTeacherDestroy;
import mx.edu.itoaxaca.api.v1.departament_teacher.application.DepartamentTeacherGetAll;
import mx.edu.itoaxaca.api.v1.departament_teacher.application.DepartamentTeacherGetById;
import mx.edu.itoaxaca.api.v1.departament_teacher.application.DepartamentTeacherUpdate;
import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacher;
import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacherRepository;
import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacherStoreRequest;
import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacherUpdateRequest;
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
@RequestMapping(value = Routes.)
@RequiredArgsConstructor
public class DepartamentTeacherController {
    private final DepartamentTeacherRepository repo;

    @GetMapping
    Page<DepartamentTeacher> index() {
        return DepartamentTeacherGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    DepartamentTeacher show(@PathVariable UUID id) {
        return DepartamentTeacherGetById.run(repo, id);
    }

    @PostMapping
    DepartamentTeacher store(@Valid @RequestBody DepartamentTeacherStoreRequest request) {
        return DepartamentTeacherCreate.run(repo, request.asDepartamentTeacher());
    }

    @PutMapping(value = "/{id}")
    DepartamentTeacher update(
        @PathVariable UUID id,
        @Valid @RequestBody DepartamentTeacherUpdateRequest request
    ) {
        return DepartamentTeacherUpdate.run(repo, id, request.asDepartamentTeacher());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        DepartamentTeacherDestroy.run(repo, id);
    }
}
