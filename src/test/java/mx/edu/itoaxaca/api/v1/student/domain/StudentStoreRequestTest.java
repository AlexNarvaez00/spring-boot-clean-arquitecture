package mx.edu.itoaxaca.api.v1.student.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StudentStoreRequestTest {

    @Test
    void testAsStudent() {
        Student student = StudentMother.random();
        var request = new StudentStoreRequest();
        request.setControl_number(student.getControlNumber().getValue());

        var studentFromReq = request.asStudent();

        assertEquals(
            student.getControlNumber().getValue(),
            studentFromReq.getControlNumber().getValue()
        );
    }
}
