package mx.edu.itoaxaca.api.v1.student.domain;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileMother;
import mx.edu.itoaxaca.api.v1.shared.FakerService;

public class StudentMother {

    public static Student random() {
        var faker = FakerService.create();

        return new Student(
            UUID.randomUUID(),
            new StudentControlNumber(faker.random().hex(3)),
            ProfileMother.random()
        );
    }
}
