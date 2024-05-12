package mx.edu.itoaxaca.api.v1.departament_teacher.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacherRepository;

public class DepartamentTeacherDestroy {
    public static void run(DepartamentTeacherRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
