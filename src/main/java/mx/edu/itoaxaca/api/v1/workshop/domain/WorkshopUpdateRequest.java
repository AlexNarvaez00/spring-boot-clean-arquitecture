package mx.edu.itoaxaca.api.v1.workshop.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mx.edu.itoaxaca.api.v1.career.domain.Career;

@Data
public class WorkshopUpdateRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String speaker;

    @NotNull
    private LocalDate date;

    @NotBlank
    private String speaker_institution;

    @NotEmpty
    private UUID[] career_ids;

    public Workshop aWorkshop() {
        return new Workshop(
            null,
            new WorkshopName(this.name),
            new WorkshopDate(this.date),
            new WorkshopSpeaker(this.speaker),
            new WorkshopSpeakerInstitution(this.speaker_institution),
            List.of(this.career_ids)
                .stream()
                .map(id -> new Career(id, null, null))
                .toList()
        );
    }
}
