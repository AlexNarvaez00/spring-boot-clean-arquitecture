package mx.edu.itoaxaca.api.v1.shared.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface BaseApiController {
    public void index();

    public void show();

    public void store();

    public void update();

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy();
}
