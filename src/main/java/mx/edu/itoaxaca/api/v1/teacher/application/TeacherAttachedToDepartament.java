package mx.edu.itoaxaca.api.v1.teacher.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.departament.domain.Departament;
import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacher;
import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacherRepository;
import mx.edu.itoaxaca.api.v1.teacher.domain.Teacher;

public class TeacherAttachedToDepartament {

    public static DepartamentTeacher run(
        DepartamentTeacherRepository repo,
        Teacher teacher,
        Departament departament
    ) {
        return repo.save(
            new DepartamentTeacher(UUID.randomUUID(), teacher.getProfile(), departament)
        );
    }
}
