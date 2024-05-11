package mx.edu.itoaxaca.api.v1.student.application;

import mx.edu.itoaxaca.api.v1.student.domain.Student;
import mx.edu.itoaxaca.api.v1.student.domain.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class StudentGetAll {
    public static Page<Student> run(Pageable pageable, StudentRepository repo) {
        return repo.findAll(pageable);
    }
}
