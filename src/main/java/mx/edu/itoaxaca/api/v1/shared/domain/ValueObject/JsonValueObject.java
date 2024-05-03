package mx.edu.itoaxaca.api.v1.shared.domain.ValueObject;

import java.util.HashMap;
import lombok.Getter;

public abstract class JsonValueObject implements ValueObject<HashMap<String, Object>> {

    @Getter
    private HashMap<String, Object> value;

    public JsonValueObject(HashMap<String, Object> value) {
        this.value = value;
    }

    @Override
    public boolean isValid(HashMap<String, Object> value) {
        return value != null;
    }
}
