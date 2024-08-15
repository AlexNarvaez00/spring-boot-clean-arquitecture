package mx.edu.itoaxaca.api.v1.groups.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.groups.application.GroupCreate;
import mx.edu.itoaxaca.api.v1.groups.application.GroupDelete;
import mx.edu.itoaxaca.api.v1.groups.application.GroupGetAll;
import mx.edu.itoaxaca.api.v1.groups.application.GroupGetById;
import mx.edu.itoaxaca.api.v1.groups.application.GroupUpdate;
import mx.edu.itoaxaca.api.v1.groups.domain.Group;
import mx.edu.itoaxaca.api.v1.groups.domain.GroupRepository;
import mx.edu.itoaxaca.api.v1.groups.domain.GroupStoreRequest;
import mx.edu.itoaxaca.api.v1.groups.domain.GroupUpdateRequest;
import mx.edu.itoaxaca.api.v1.shared.Config;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping(value = Routes.API_V1_GROUP_BASE)
@RequiredArgsConstructor
@CrossOrigin(value = Config.BASE_URL_FRONTED)
public class GroupController {

    private final GroupRepository repo;

    @GetMapping(value = "")
    public Page<Group> index() {
        return GroupGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    public Group show(@PathVariable UUID id) {
        return GroupGetById.run(repo, id);
    }

    @PutMapping(value = "/{id}")
    public Group update(@PathVariable UUID id, @Valid @RequestBody GroupUpdateRequest resuquest) {
        return GroupUpdate.run(repo, id, resuquest.asGroup());
    }

    @PostMapping(value = "")
    public Group store(@Valid @RequestBody GroupStoreRequest request) {
        return GroupCreate.run(repo, request.asGroup());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable UUID id) {
        GroupDelete.run(repo, id);
    }
}
