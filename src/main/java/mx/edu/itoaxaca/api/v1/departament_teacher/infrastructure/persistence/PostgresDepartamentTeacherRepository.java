package mx.edu.itoaxaca.api.v1.departament_teacher.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacher;
import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacherRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresDepartamentTeacherRepository 
    extends JpaRepository<DepartamentTeacher, UUID>, DepartamentTeacherRepository {}
