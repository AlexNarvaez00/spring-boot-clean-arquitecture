package mx.edu.itoaxaca.api.v1.group_tutor_student.application;

import mx.edu.itoaxaca.api.v1.group_tutor_student.domain.GroupTutorStudent;
import mx.edu.itoaxaca.api.v1.group_tutor_student.domain.GroupTutorStudentRepository;

public class GroupTutorStudentCreate {
    public static GroupTutorStudent run(GroupTutorStudentRepository repo, GroupTutorStudent arg) {
        return repo.save(arg);
    }
}
