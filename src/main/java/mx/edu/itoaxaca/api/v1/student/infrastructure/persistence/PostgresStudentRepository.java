package mx.edu.itoaxaca.api.v1.student.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.student.domain.Student;
import mx.edu.itoaxaca.api.v1.student.domain.StudentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresStudentRepository 
    extends JpaRepository<Student, UUID>, StudentRepository {}
