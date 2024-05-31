package mx.edu.itoaxaca.api.v1.student.infrastructure.controllers;

import java.util.HashMap;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.student.domain.StudentMother;
import mx.edu.itoaxaca.api.v1.student.domain.StudentRepository;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.RestClientTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(StudentController.class)
public class StudentControllerTest extends RestClientTest<StudentRepository>{
    @Test
    void testDestroy() throws Exception {
        var student = StudentMother.random();
        Mockito.when(this.getRepo().findStudentById(student.getId())).thenReturn(
            student
        );
        var url = Routes.API_V1_STUDENT_BASE + "/" + student.getId().toString();
        this.delete(url).andExpect(
                MockMvcResultMatchers.status().isNoContent()
            );
    }

    @Test
    void testIndex() throws Exception {
        this.get(Routes.API_V1_STUDENT_BASE).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testShow() throws Exception {
        var student = StudentMother.random();
        Mockito.when(this.getRepo().findStudentById(student.getId())).thenReturn(
            student
        );

        var url = Routes.API_V1_STUDENT_BASE + "/" + student.getId().toString();

        this.get(url).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testStore() throws Exception {
        var student = StudentMother.random();
        var request = new HashMap<String, String>();

        this.post(Routes.API_V1_STUDENT_BASE, request).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testUpdate() throws Exception {
        var student = StudentMother.random();
        var studentUpdate = StudentMother.random();

        var request = new HashMap<String, String>();

        Mockito.when(this.getRepo().findStudentById(student.getId())).thenReturn(
            studentUpdate
        );

        var url = Routes.API_V1_STUDENT_BASE + "/" + student.getId().toString();
        this.put(url, request).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
