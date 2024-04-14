package mx.edu.itoaxaca.api.v1.syllabus.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;

@Data
public class SyllabusStoreRequest {

    private UUID id;

    @NotEmpty
    private String code;

    @NotNull
    private LocalDate start_date;

    @NotNull
    private LocalDate end_date;

    public Syllabus asSyllabus() {
        return new Syllabus(
            id != null ? id : UUID.randomUUID(),
            new SyllabusCode(this.code),
            new SyllabusStartDate(this.start_date),
            new SyllabusEndDate(this.end_date)
        );
    }
}
