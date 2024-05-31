package mx.edu.itoaxaca.api.v1.student.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import mx.edu.itoaxaca.api.v1.student.domain.Student;
import mx.edu.itoaxaca.api.v1.student.infrastructure.persistence.StudentRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class StudentGetAllTest {
    @Test
    void runTest() {
        var creator = new StudentGetAll();

        var repo = StudentRepositoryMock.mock();

        PageRequest pageReq = PageRequest.of(0, 2);
        Page<Student> students = new PageImpl<Student>(new ArrayList<Student>(), pageReq, 0);

        Mockito.when(repo.findAll(pageReq)).thenReturn(students);
        Page<Student> all = StudentGetAll.run(pageReq, repo);
        assertEquals(all.getSize(), 2);
    }
}
