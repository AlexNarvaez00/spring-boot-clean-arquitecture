package mx.edu.itoaxaca.api.v1.group_tutor_student.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupTutorStudentRepository {
    GroupTutorStudent save(GroupTutorStudent arg);
    Page<GroupTutorStudent> findAll(Pageable pageable);
    void deleteById(UUID id);
    GroupTutorStudent findGroupTutorStudentById(UUID id);
}
