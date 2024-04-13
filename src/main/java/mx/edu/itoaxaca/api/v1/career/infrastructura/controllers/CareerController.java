package mx.edu.itoaxaca.api.v1.career.infrastructura.controllers;

import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.career.application.CareerGetAll;
import mx.edu.itoaxaca.api.v1.career.domain.Career;
import mx.edu.itoaxaca.api.v1.career.domain.CareerRespository;
import mx.edu.itoaxaca.api.v1.career.domain.CareerStoreRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Routes.API_V1_CAREER_BASE)
public class CareerController {

    @Autowired
    public CareerRespository repo;

    @GetMapping(value = "")
    Page<Career> index() {
        PageRequest pageable = PageRequest.of(0, 10);
        return CareerGetAll.run(pageable, repo);
    }

    @PostMapping(value = "")
    Career store(@RequestBody CareerStoreRequest request) {
        return request.asCareer();
    }
}
