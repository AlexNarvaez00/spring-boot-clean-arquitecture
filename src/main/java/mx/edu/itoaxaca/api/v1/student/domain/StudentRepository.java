package mx.edu.itoaxaca.api.v1.student.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentRepository {
    Student save(Student arg);
    Page<Student> findAll(Pageable pageable);
    void deleteById(UUID id);
    Student findStudentById(UUID id);
}
