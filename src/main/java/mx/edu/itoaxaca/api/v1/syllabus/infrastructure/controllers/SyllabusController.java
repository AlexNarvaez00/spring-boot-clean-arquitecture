package mx.edu.itoaxaca.api.v1.syllabus.infrastructure.controllers;

import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.syllabus.application.SyllabusCreate;
import mx.edu.itoaxaca.api.v1.syllabus.application.SyllabusGetAll;
import mx.edu.itoaxaca.api.v1.syllabus.domain.Syllabus;
import mx.edu.itoaxaca.api.v1.syllabus.domain.SyllabusRepository;
import mx.edu.itoaxaca.api.v1.syllabus.domain.SyllabusStoreRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping
    Syllabus store(@RequestBody SyllabusStoreRequest request) {
        return SyllabusCreate.run(repo, request.asSyllabus());
    }
}
