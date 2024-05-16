package mx.edu.itoaxaca.api.v1.shared.domain;

import java.time.LocalDateTime;

public class UpdatedAtMother extends UpdatedAt {

    public UpdatedAtMother(LocalDateTime value) {
        super(value);
    }

    public static UpdatedAt random() {
        return new UpdatedAtMother(LocalDateTime.now());
    }
}
