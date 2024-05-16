package mx.edu.itoaxaca.api.v1.shared.domain;

import java.time.LocalDateTime;

public class CreatedAtMother extends CreatedAt{

    public CreatedAtMother(LocalDateTime value) {
        super(value);
    }

    public static CreatedAt random(){
        return new CreatedAtMother(LocalDateTime.now());
    }
}
