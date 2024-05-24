package mx.edu.itoaxaca.api.v1.shared.domain.errors;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Configuration
public class IlegalArgumentController {

    @ExceptionHandler(value = { IllegalArgumentValueObjectException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(
        IllegalArgumentValueObjectException exception
    ) {
        var response = new ErrorResponse();
        response.add(exception.getName(), exception.getMessage());
        return response;
    }
}
