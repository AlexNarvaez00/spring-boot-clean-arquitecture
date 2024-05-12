package mx.edu.itoaxaca.api.v1.departament_teacher.application;

import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacher;
import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacherRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class DepartamentTeacherGetAll {
    public static Page<DepartamentTeacher> run(Pageable pageable, DepartamentTeacherRepository repo) {
        return repo.findAll(pageable);
    }
}
