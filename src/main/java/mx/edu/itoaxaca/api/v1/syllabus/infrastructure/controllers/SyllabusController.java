package mx.edu.itoaxaca.api.v1.syllabus.infrastructure.controllers;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.syllabus.application.SyllabusCreate;
import mx.edu.itoaxaca.api.v1.syllabus.application.SyllabusDelete;
import mx.edu.itoaxaca.api.v1.syllabus.application.SyllabusGetAll;
import mx.edu.itoaxaca.api.v1.syllabus.application.SyllabusGetById;
import mx.edu.itoaxaca.api.v1.syllabus.application.SyllabusUpdate;
import mx.edu.itoaxaca.api.v1.syllabus.domain.Syllabus;
import mx.edu.itoaxaca.api.v1.syllabus.domain.SyllabusRepository;
import mx.edu.itoaxaca.api.v1.syllabus.domain.SyllabusStoreRequest;
import mx.edu.itoaxaca.api.v1.syllabus.domain.SyllabusUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_SYLLABUS_BASE)
@RequiredArgsConstructor
public class SyllabusController {

    private final SyllabusRepository repo;

    @GetMapping(value = "")
    Page<Syllabus> index() {
        return SyllabusGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    Syllabus show(@PathVariable UUID id) {
        return SyllabusGetById.run(repo, id);
    }

    @PostMapping
    Syllabus store(@RequestBody SyllabusStoreRequest request) {
        return SyllabusCreate.run(repo, request.asSyllabus());
    }

    @PutMapping(value = "/{id}")
    Syllabus update(@PathVariable UUID id, @RequestBody SyllabusUpdateRequest request) {
        return SyllabusUpdate.run(repo, id, request.asSyllabus());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        SyllabusDelete.run(repo, id);
    }
}
