package mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.type_support_area.application.TypeSupportAreaGetAll;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaPrimitives;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaRepository;

@RestController
@RequestMapping(value = Routes.API_V1_TYPE_SUPPORT_AREAS_BASE)
@RequiredArgsConstructor
public class TypeSupportAreaController {

    private final TypeSupportAreaRepository repo;

    @GetMapping
    List<TypeSupportAreaPrimitives> index() {
        return TypeSupportAreaGetAll.run(repo);
    }

    // @GetMapping(value = "/{id}")
    // TypeSupportArea show(@PathVariable UUID id) {
    //     return TypeSupportAreaGetById.run(repo, id);
    // }

    // @PostMapping
    // TypeSupportArea store(
    //     @Valid @RequestBody TypeSupportAreaStoreRequest request
    // ) {
    //     return TypeSupportAreaCreate.run(repo, request.asTypeSupportArea());
    // }

    // @PutMapping(value = "/{id}")
    // TypeSupportArea update(
    //     @PathVariable UUID id,
    //     @Valid @RequestBody TypeSupportAreaUpdateRequest request
    // ) {
    //     return TypeSupportAreaUpdate.run(repo, id, request.asTypeSupportArea());
    // }

    // @DeleteMapping(value = "/{id}")
    // @ResponseStatus(value = HttpStatus.NO_CONTENT)
    // void destroy(@PathVariable UUID id) {
    //     TypeSupportAreaDestroy.run(repo, id);
    // }
}
