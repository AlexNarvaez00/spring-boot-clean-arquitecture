package mx.edu.itoaxaca.api.v1.student.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.student.domain.Student;
import mx.edu.itoaxaca.api.v1.student.domain.StudentRepository;

public class StudentUpdate {
    public static Student run(
        StudentRepository repo,
        UUID id,
        Student arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
