package mx.edu.itoaxaca.api.v1.syllabus.domain;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.career.domain.Career;
import mx.edu.itoaxaca.api.v1.shared.FakerService;
import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.DateValueObjectMother;
import mx.edu.itoaxaca.api.v1.speciality.domain.Speciality;

public class SyllabusMother {

    public static Syllabus random() {
        var faker = FakerService.create();

        return new Syllabus(
            UUID.randomUUID(),
            new SyllabusCode(faker.random().hex(5)),
            new SyllabusStartDate(DateValueObjectMother.random()),
            new SyllabusEndDate(DateValueObjectMother.random()),
            new Career(UUID.randomUUID(), null, null),
            new Speciality(UUID.randomUUID(), null, null, null)
        );
    }
}
