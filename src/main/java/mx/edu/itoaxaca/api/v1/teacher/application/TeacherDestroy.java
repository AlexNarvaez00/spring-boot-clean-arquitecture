package mx.edu.itoaxaca.api.v1.teacher.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.teacher.domain.TeacherRepository;

public class TeacherDestroy {
    public static void run(TeacherRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
