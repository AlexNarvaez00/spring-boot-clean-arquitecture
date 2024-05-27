package mx.edu.itoaxaca.api.v1.teacher.domain;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileMother;
import mx.edu.itoaxaca.api.v1.shared.FakerService;

public class TeacherMother {

    public static Teacher random() {
        var faker = FakerService.create();

        return new Teacher(
            UUID.randomUUID(),
            new TeacherType(faker.name().firstName()),
            ProfileMother.random()
        );
    }
}
