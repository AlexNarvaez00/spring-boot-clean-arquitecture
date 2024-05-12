package mx.edu.itoaxaca.api.v1.departament_teacher.application;

import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacher;
import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacherRepository;

public class DepartamentTeacherCreate {
    public static DepartamentTeacher run(DepartamentTeacherRepository repo, DepartamentTeacher arg) {
        return repo.save(arg);
    }
}
