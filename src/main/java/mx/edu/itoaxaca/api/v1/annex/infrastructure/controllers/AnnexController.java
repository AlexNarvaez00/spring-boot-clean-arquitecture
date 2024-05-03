package mx.edu.itoaxaca.api.v1.annex.infrastructure.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.annex.application.AnnexCreate;
import mx.edu.itoaxaca.api.v1.annex.application.AnnexDestroy;
import mx.edu.itoaxaca.api.v1.annex.application.AnnexGetAll;
import mx.edu.itoaxaca.api.v1.annex.application.AnnexGetById;
import mx.edu.itoaxaca.api.v1.annex.application.AnnexUpdate;
import mx.edu.itoaxaca.api.v1.annex.domain.Annex;
import mx.edu.itoaxaca.api.v1.annex.domain.AnnexRepository;
import mx.edu.itoaxaca.api.v1.annex.domain.AnnexStoreRequest;
import mx.edu.itoaxaca.api.v1.annex.domain.AnnexUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_ANNEX_BASE)
@RequiredArgsConstructor
public class AnnexController {

    private final AnnexRepository repo;

    @GetMapping
    Page<Annex> index() {
        return AnnexGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    Annex show(@PathVariable UUID id) {
        return AnnexGetById.run(repo, id);
    }

    @PostMapping
    Annex store(@Valid @RequestBody AnnexStoreRequest request)
        throws JsonMappingException, JsonProcessingException {
        return AnnexCreate.run(repo, request.asAnnex());
    }

    @PutMapping(value = "/{id}")
    Annex update(@PathVariable UUID id, @Valid @RequestBody AnnexUpdateRequest request)
        throws JsonMappingException, JsonProcessingException {
        return AnnexUpdate.run(repo, id, request.asAnnex());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        AnnexDestroy.run(repo, id);
    }
}
