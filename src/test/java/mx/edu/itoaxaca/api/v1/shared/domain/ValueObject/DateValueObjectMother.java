package mx.edu.itoaxaca.api.v1.shared.domain.ValueObject;

import com.github.javafaker.Faker;
import java.time.LocalDate;

public class DateValueObjectMother extends DateValueObject {

    public DateValueObjectMother(LocalDate value) {
        super(value);
    }

    public static LocalDate random() {
        Faker fake = new Faker();
        return LocalDate.of(
            fake.random().nextInt(2020, 2030),
            fake.random().nextInt(1, 12),
            fake.random().nextInt(1, 31)
        );
    }
}
