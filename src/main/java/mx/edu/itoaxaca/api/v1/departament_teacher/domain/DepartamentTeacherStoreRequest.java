package mx.edu.itoaxaca.api.v1.departament_teacher.domain;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DepartamentTeacherStoreRequest {
    private UUID id;

    @NotNull
    private String name;

    public DepartamentTeacher asDepartamentTeacher() {
        return new DepartamentTeacher(
            (this.id == null) ? null : UUID.randomUUID(),
            new DepartamentTeacherName(this.name)
        );
    }
}
