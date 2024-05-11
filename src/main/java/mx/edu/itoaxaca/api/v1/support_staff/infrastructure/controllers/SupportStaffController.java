package mx.edu.itoaxaca.api.v1.support_staff.infrastructure.controllers;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.support_staff.application.SupportStaffCreate;
import mx.edu.itoaxaca.api.v1.support_staff.application.SupportStaffDestroy;
import mx.edu.itoaxaca.api.v1.support_staff.application.SupportStaffGetAll;
import mx.edu.itoaxaca.api.v1.support_staff.application.SupportStaffGetById;
import mx.edu.itoaxaca.api.v1.support_staff.application.SupportStaffUpdate;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaff;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaffRepository;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaffStoreRequest;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaffUpdateRequest;
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
@RequestMapping(value = Routes.API_V1_SUPPORT_STAFF_BASE)
@RequiredArgsConstructor
public class SupportStaffController {
    private final SupportStaffRepository repo;

    @GetMapping
    Page<SupportStaff> index() {
        return SupportStaffGetAll.run(PageRequest.of(0, 10), repo);
    }

    @GetMapping(value = "/{id}")
    SupportStaff show(@PathVariable UUID id) {
        return SupportStaffGetById.run(repo, id);
    }

    @PostMapping
    SupportStaff store(@Valid @RequestBody SupportStaffStoreRequest request) {
        return SupportStaffCreate.run(repo, request.asSupportStaff());
    }

    @PutMapping(value = "/{id}")
    SupportStaff update(
        @PathVariable UUID id,
        @Valid @RequestBody SupportStaffUpdateRequest request
    ) {
        return SupportStaffUpdate.run(repo, id, request.asSupportStaff());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void destroy(@PathVariable UUID id) {
        SupportStaffDestroy.run(repo, id);
    }
}
