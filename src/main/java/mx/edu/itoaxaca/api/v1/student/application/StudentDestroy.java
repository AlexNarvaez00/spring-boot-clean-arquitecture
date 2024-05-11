package mx.edu.itoaxaca.api.v1.student.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.student.domain.StudentRepository;

public class StudentDestroy {
    public static void run(StudentRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
