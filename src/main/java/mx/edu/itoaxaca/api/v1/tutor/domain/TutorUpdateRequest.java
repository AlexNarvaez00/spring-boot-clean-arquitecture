package mx.edu.itoaxaca.api.v1.tutor.domain;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Data;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Data
public class TutorUpdateRequest {

    @NotNull
    private String classification;

    @NotNull
    private UUID profile_id;

    public Tutor asTutor() {
        return new Tutor(
            null,
            new TutorClassification(this.classification),
            new Profile(this.profile_id, null, null, null, null, null)
        );
    }
}
