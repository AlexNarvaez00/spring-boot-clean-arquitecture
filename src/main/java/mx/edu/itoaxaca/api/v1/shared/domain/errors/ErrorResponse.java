package mx.edu.itoaxaca.api.v1.shared.domain.errors;

import lombok.Setter;
import java.util.HashMap;

@Setter
public class ErrorResponse {

    private HashMap<String, String> errors;

    public ErrorResponse() {
        this.errors = new HashMap<>();
    }

    public void add(String field, String name) {
        this.errors.put(field, name);
    }
}
