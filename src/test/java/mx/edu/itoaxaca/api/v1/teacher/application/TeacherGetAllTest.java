package mx.edu.itoaxaca.api.v1.teacher.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import mx.edu.itoaxaca.api.v1.teacher.domain.Teacher;
import mx.edu.itoaxaca.api.v1.teacher.infrastructure.persistence.TeacherRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class TeacherGetAllTest {
    @Test
    void runTest() {
        var creator = new TeacherGetAll();

        var repo = TeacherRepositoryMock.mock();

        PageRequest pageReq = PageRequest.of(0, 2);
        Page<Teacher> teachers = new PageImpl<Teacher>(new ArrayList<Teacher>(), pageReq, 0);

        Mockito.when(repo.findAll(pageReq)).thenReturn(teachers);
        Page<Teacher> all = TeacherGetAll.run(pageReq, repo);
        assertEquals(all.getSize(), 2);
    }
}
