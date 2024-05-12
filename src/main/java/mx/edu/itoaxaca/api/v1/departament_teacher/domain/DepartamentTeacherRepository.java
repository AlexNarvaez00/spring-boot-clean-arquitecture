package mx.edu.itoaxaca.api.v1.departament_teacher.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartamentTeacherRepository {
    DepartamentTeacher save(DepartamentTeacher arg);
    Page<DepartamentTeacher> findAll(Pageable pageable);
    void deleteById(UUID id);
    DepartamentTeacher findDepartamentTeacherById(UUID id);
}
