package mx.edu.itoaxaca.api.v1.departament_teacher.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacher;
import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacherRepository;

public class DepartamentTeacherGetById {
    public static DepartamentTeacher run(DepartamentTeacherRepository repo, UUID id) {
        return repo.findDepartamentTeacherById(id);
    }
}
