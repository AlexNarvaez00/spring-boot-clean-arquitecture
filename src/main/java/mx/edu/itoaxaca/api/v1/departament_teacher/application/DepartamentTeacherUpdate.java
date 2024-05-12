package mx.edu.itoaxaca.api.v1.departament_teacher.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacher;
import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacherRepository;

public class DepartamentTeacherUpdate {
    public static DepartamentTeacher run(
        DepartamentTeacherRepository repo,
        UUID id,
        DepartamentTeacher arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
