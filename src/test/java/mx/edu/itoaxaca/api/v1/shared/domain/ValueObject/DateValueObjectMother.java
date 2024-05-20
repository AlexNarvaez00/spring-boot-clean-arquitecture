package mx.edu.itoaxaca.api.v1.shared.domain.ValueObject;

import com.github.javafaker.Faker;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class DateValueObjectMother extends DateValueObject {

    public DateValueObjectMother(LocalDate value) {
        super(value);
    }

    public static LocalDate random() {
        Faker fake = new Faker();

        var time = fake.date().birthday().getTime();
        Instant instant = Instant.ofEpochMilli(time);

        return LocalDate.ofInstant(instant, ZoneId.systemDefault());
    }
}
