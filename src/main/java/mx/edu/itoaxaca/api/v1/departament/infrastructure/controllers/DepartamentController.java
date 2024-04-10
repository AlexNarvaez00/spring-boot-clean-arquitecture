package mx.edu.itoaxaca.api.v1.departament.infrastructure.controllers;

import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.departament.domain.Departament;
import mx.edu.itoaxaca.api.v1.departament.domain.DepartamentRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Routes.API_V1_DEPARTAMENTE_INDEX)
public class DepartamentController {

    @GetMapping(value = "")
    String index() {
        return "Hola";
    }

    @PostMapping(value = "")
    Departament store(@RequestBody DepartamentRequest request) {
        return request.asDepartament();
    }
}
