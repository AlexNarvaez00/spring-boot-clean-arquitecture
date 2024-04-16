package mx.edu.itoaxaca.api.v1.groups.domain;

import java.time.LocalDate;
import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.DateValueObject;

public class GroupCreatedAt extends DateValueObject {

    public GroupCreatedAt(LocalDate value) {
        super(value);
    }
}
