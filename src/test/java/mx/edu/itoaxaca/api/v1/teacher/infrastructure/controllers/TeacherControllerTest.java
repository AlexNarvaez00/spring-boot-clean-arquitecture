package mx.edu.itoaxaca.api.v1.teacher.infrastructure.controllers;

import java.util.HashMap;
import java.util.UUID;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacherRepository;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.RestClientTest;
import mx.edu.itoaxaca.api.v1.teacher.domain.TeacherMother;
import mx.edu.itoaxaca.api.v1.teacher.domain.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TeacherController.class)
public class TeacherControllerTest extends RestClientTest<TeacherRepository> {

    @MockBean
    private DepartamentTeacherRepository repoDepartamentTeacherMock;

    @Test
    void testDestroy() throws Exception {
        var teacher = TeacherMother.random();
        var url = Routes.API_V1_TEACHER_BASE + "/" + teacher.getId().toString();
        Mockito.doNothing().when(this.getRepo()).deleteById(teacher.getId());
        this.delete(url).andExpect(
                MockMvcResultMatchers.status().isNoContent()
            );
    }

    @Test
    void testIndex() throws Exception {
        this.get(Routes.API_V1_TEACHER_BASE).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testShow() throws Exception {
        var teacher = TeacherMother.random();
        Mockito.when(
            this.getRepo().findTeacherById(teacher.getId())
        ).thenReturn(teacher);

        var url = Routes.API_V1_TEACHER_BASE + "/" + teacher.getId().toString();

        this.get(url).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testStore() throws Exception {
        var teacher = TeacherMother.random();
        var request = new HashMap<String, String>();
        request.put("type", teacher.getType().getValue());
        request.put("profile_id", teacher.getProfile().getId().toString());
        request.put("departament_id", UUID.randomUUID().toString());
        
        Mockito.when(this.getRepo().save(teacher)).thenReturn(teacher);
        
        this.post(Routes.API_V1_TEACHER_BASE, request).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testUpdate() throws Exception {
        var teacher = TeacherMother.random();
        var teacherUpdate = TeacherMother.random();

        var request = new HashMap<String, String>();
        request.put("type", teacherUpdate.getType().getValue());
        request.put(
            "profile_id",
            teacherUpdate.getProfile().getId().toString()
        );

        Mockito.when(
            this.getRepo().findTeacherById(teacher.getId())
        ).thenReturn(teacherUpdate);

        var url = Routes.API_V1_TEACHER_BASE + "/" + teacher.getId().toString();
        this.put(url, request).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
