package mx.edu.itoaxaca.api.v1.speciality.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SpecialityUpdateRequestTest {

    @Test
    void testAsSpeciality() {
        Speciality speciality = SpecialityMother.random();
        var request = new SpecialityUpdateRequest();
        request.setCode(speciality.getCode().getValue());
        request.setStart_date(speciality.getStart_date().getValue());
        request.setEnd_date(speciality.getEnd_date().getValue());

        var specialityFromReq = request.asSpeciality();

        assertEquals(
            speciality.getCode().getValue(),
            specialityFromReq.getCode().getValue()
        );
    }
}
