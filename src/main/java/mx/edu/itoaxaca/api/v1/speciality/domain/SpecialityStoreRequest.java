package mx.edu.itoaxaca.api.v1.speciality.domain;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SpecialityStoreRequest {
    private UUID id;

    @NotNull
    private String code;

    @NotNull
    private LocalDate start_date;
    
    @NotNull
    private LocalDate end_date;
    
    public Speciality asSpeciality() {
        return new Speciality(
            (this.id == null) ? null : UUID.randomUUID(),
            new SpecialityCode(this.code),
            new SpecialityStartDate(this.start_date),
            new SpecialityEndDate(this.end_date)
        );
    }
}
