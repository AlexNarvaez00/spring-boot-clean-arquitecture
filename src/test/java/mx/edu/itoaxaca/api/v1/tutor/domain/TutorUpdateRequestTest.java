package mx.edu.itoaxaca.api.v1.tutor.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TutorUpdateRequestTest {

    @Test
    void testAsTutor() {
        Tutor tutor = TutorMother.random();
        var request = new TutorUpdateRequest();
        request.setClassification(tutor.getClassification().getValue());

        var tutorFromReq = request.asTutor();

        assertEquals(
            tutorFromReq.getClassification().getValue(),
            tutor.getClassification().getValue()
        );
    }
}
