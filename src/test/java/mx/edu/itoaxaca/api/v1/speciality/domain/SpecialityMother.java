package mx.edu.itoaxaca.api.v1.speciality.domain;

import java.util.UUID;

import mx.edu.itoaxaca.api.v1.shared.FakerService;
import mx.edu.itoaxaca.api.v1.shared.domain.ValueObject.DateValueObjectMother;

public class SpecialityMother {

    public static Speciality random() {
        var faker = FakerService.create();
        
        
        return new Speciality(
            UUID.randomUUID(),
            new SpecialityCode(faker.random().hex(5)),
            new SpecialityStartDate(DateValueObjectMother.random()),
            new SpecialityEndDate(DateValueObjectMother.random())
        );
    }
}
