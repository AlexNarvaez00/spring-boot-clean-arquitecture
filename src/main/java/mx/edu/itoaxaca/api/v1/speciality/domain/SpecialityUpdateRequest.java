package mx.edu.itoaxaca.api.v1.speciality.domain;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Data;

@Data
public class SpecialityUpdateRequest {

    @NotNull
    private String code;

    @NotNull
    private LocalDate start_date;

    @NotNull
    private LocalDate end_date;

    public Speciality asSpeciality() {
        return new Speciality(
            null,
            new SpecialityCode(this.code),
            new SpecialityStartDate(this.start_date),
            new SpecialityEndDate(this.end_date)
        );
    }
}
