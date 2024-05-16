package mx.edu.itoaxaca.api.v1.shared.domain;

import java.time.LocalDateTime;

public class DeletedAtMother extends DeletedAt{

    public DeletedAtMother(LocalDateTime value) {
        super(value);
    }

    public static DeletedAt random(){
        return new DeletedAtMother(LocalDateTime.now());
    }
}
