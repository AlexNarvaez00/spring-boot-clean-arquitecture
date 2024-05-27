package mx.edu.itoaxaca.api.v1.teacher.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TeacherStoreRequestTest {

    @Test
    void testAsTeacher() {
        Teacher teacher = TeacherMother.random();
        var request = new TeacherStoreRequest();
        request.setType(teacher.getType().getValue());
        
        var teacherFromReq = request.asTeacher();
        
        assertEquals(
            teacherFromReq.getType().getValue(),
            teacher.getType().getValue()
        );
    } 
}
