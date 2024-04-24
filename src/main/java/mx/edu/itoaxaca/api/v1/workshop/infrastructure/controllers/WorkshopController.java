package mx.edu.itoaxaca.api.v1.workshop.infrastructure.controllers;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.workshop.application.WorkshopCreate;
import mx.edu.itoaxaca.api.v1.workshop.application.WorkshopDelete;
import mx.edu.itoaxaca.api.v1.workshop.application.WorkshopGetById;
import mx.edu.itoaxaca.api.v1.workshop.application.WorkshopGretAll;
import mx.edu.itoaxaca.api.v1.workshop.application.WorkshopUpdate;
import mx.edu.itoaxaca.api.v1.workshop.domain.Workshop;
import mx.edu.itoaxaca.api.v1.workshop.domain.WorkshopRepository;
import mx.edu.itoaxaca.api.v1.workshop.domain.WorkshopStoreRequest;
import mx.edu.itoaxaca.api.v1.workshop.domain.WorkshopUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = Routes.API_V1_WORKSHOP_BASE)
public class WorkshopController {

    private final WorkshopRepository repo;

    @GetMapping(value = "")
    Page<Workshop> index() {
        return WorkshopGretAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    Workshop show(@PathVariable UUID id) {
        return WorkshopGetById.run(repo, id);
    }

    @PostMapping(value = "")
    Workshop store(@RequestBody WorkshopStoreRequest request) {
        return WorkshopCreate.run(repo, request.aWorkshop());
    }

    @PutMapping(value = "/{id}")
    Workshop update(@PathVariable UUID id, @RequestBody WorkshopUpdateRequest request) {
        return WorkshopUpdate.run(repo, id, request.aWorkshop());
    }

    @DeleteMapping(value = "/{id}")
    void destroy(@PathVariable UUID id){
        WorkshopDelete.run(repo, id);
    }
}
