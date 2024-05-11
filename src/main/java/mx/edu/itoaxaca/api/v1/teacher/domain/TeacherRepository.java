package mx.edu.itoaxaca.api.v1.teacher.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherRepository {
    Teacher save(Teacher arg);
    Page<Teacher> findAll(Pageable pageable);
    void deleteById(UUID id);
    Teacher findTeacherById(UUID id);
}
