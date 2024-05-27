package mx.edu.itoaxaca.api.v1.syllabus.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.career.domain.Career;
import mx.edu.itoaxaca.api.v1.speciality.domain.Speciality;

@Setter
public class SyllabusUpdateRequest {

    @NotEmpty
    private String code;

    @NotNull
    private LocalDate start_date;

    @NotNull
    private LocalDate end_date;

    @NotNull
    private UUID career_id;

    @NotNull
    private UUID speciality_id;

    public Syllabus asSyllabus() {
        return new Syllabus(
            null,
            new SyllabusCode(this.code),
            new SyllabusStartDate(this.start_date),
            new SyllabusEndDate(this.end_date),
            new Career(this.career_id, null, null),
            new Speciality(this.speciality_id, null, null, null)
        );
    }
}
