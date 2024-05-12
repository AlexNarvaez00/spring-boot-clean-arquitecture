package mx.edu.itoaxaca.api.v1.group_tutor_student.application;

import mx.edu.itoaxaca.api.v1.group_tutor_student.domain.GroupTutorStudent;
import mx.edu.itoaxaca.api.v1.group_tutor_student.domain.GroupTutorStudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class GroupTutorStudentGetAll {
    public static Page<GroupTutorStudent> run(Pageable pageable, GroupTutorStudentRepository repo) {
        return repo.findAll(pageable);
    }
}
