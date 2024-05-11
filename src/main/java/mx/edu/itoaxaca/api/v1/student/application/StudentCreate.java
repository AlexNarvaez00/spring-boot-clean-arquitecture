package mx.edu.itoaxaca.api.v1.student.application;

import mx.edu.itoaxaca.api.v1.student.domain.Student;
import mx.edu.itoaxaca.api.v1.student.domain.StudentRepository;

public class StudentCreate {
    public static Student run(StudentRepository repo, Student arg) {
        return repo.save(arg);
    }
}
