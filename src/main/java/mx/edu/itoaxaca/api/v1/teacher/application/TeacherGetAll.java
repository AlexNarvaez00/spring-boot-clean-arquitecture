package mx.edu.itoaxaca.api.v1.teacher.application;

import mx.edu.itoaxaca.api.v1.teacher.domain.Teacher;
import mx.edu.itoaxaca.api.v1.teacher.domain.TeacherRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class TeacherGetAll {
    public static Page<Teacher> run(Pageable pageable, TeacherRepository repo) {
        return repo.findAll(pageable);
    }
}
