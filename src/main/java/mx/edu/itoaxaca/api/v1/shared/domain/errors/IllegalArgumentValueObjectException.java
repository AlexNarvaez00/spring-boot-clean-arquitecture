package mx.edu.itoaxaca.api.v1.shared.domain.errors;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalArgumentValueObjectException
    extends IllegalArgumentException {

    @Getter
    private String name;

    public IllegalArgumentValueObjectException(String name, String message) {
        super(message);
        this.name = name;
    }
}
