package mx.edu.itoaxaca.api.v1.group_tutor_student.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.group_tutor_student.domain.GroupTutorStudent;
import mx.edu.itoaxaca.api.v1.group_tutor_student.domain.GroupTutorStudentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresGroupTutorStudentRepository 
    extends JpaRepository<GroupTutorStudent, UUID>, GroupTutorStudentRepository {}
