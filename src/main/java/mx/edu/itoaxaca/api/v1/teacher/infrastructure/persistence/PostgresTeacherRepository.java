package mx.edu.itoaxaca.api.v1.teacher.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.teacher.domain.Teacher;
import mx.edu.itoaxaca.api.v1.teacher.domain.TeacherRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresTeacherRepository 
    extends JpaRepository<Teacher, UUID>, TeacherRepository {}
