package mx.edu.itoaxaca.api.v1.tutor.domain;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Data;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Data
public class TutorStoreRequest {

    private UUID id;

    @NotNull
    private String classification;

    @NotNull
    private UUID profile_id;

    public Tutor asTutor() {
        return new Tutor(
            (this.id == null) ? null : UUID.randomUUID(),
            new TutorClassification(this.classification),
            new Profile(this.profile_id, null, null, null, null, null)
        );
    }
}
