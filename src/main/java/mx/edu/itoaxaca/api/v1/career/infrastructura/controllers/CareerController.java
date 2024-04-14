package mx.edu.itoaxaca.api.v1.career.infrastructura.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.career.application.CareerCreate;
import mx.edu.itoaxaca.api.v1.career.application.CareerDestroy;
import mx.edu.itoaxaca.api.v1.career.application.CareerGetAll;
import mx.edu.itoaxaca.api.v1.career.application.CareerGetById;
import mx.edu.itoaxaca.api.v1.career.application.CareerUpdate;
import mx.edu.itoaxaca.api.v1.career.domain.Career;
import mx.edu.itoaxaca.api.v1.career.domain.CareerRespository;
import mx.edu.itoaxaca.api.v1.career.domain.CareerStoreRequest;
import mx.edu.itoaxaca.api.v1.career.domain.CareerUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_CAREER_BASE)
@RequiredArgsConstructor
public class CareerController {

    public final CareerRespository repo;

    @GetMapping(value = "")
    Page<Career> index() {
        PageRequest pageable = PageRequest.of(0, 10);
        return CareerGetAll.run(pageable, repo);
    }

    @GetMapping(value = Routes.API_V1_CAREER_SHOW)
    Career show(@PathVariable UUID id) {
        return CareerGetById.run(repo, id);
    }

    @PostMapping(value = "")
    Career store(@RequestBody CareerStoreRequest request) {
        return CareerCreate.run(repo, request.asCareer());
    }

    @PutMapping(value = Routes.API_V1_CAREER_UPDATE)
    Career upate(@PathVariable UUID id, @Valid @RequestBody CareerUpdateRequest request) {
        return CareerUpdate.run(repo, id, request.asCareer());
    }

    @DeleteMapping(value = Routes.API_V1_CAREER_DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        CareerDestroy.run(repo, id);
    }
}
