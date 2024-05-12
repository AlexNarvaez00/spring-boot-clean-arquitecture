package mx.edu.itoaxaca.api.v1.departament_teacher.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DepartamentTeacherUpdateRequest {
    
    @NotNull
    private String name;

    public DepartamentTeacher asDepartamentTeacher() {
        return new DepartamentTeacher(
            null,
            new DepartamentTeacherName(this.name)
        );
    }
}
