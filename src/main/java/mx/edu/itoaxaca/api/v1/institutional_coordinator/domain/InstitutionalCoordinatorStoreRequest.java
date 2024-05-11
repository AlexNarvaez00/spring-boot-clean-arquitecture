package mx.edu.itoaxaca.api.v1.institutional_coordinator.domain;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Data;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Data
public class InstitutionalCoordinatorStoreRequest {

    private UUID id;

    @NotNull
    private String degree;

    @NotNull
    private UUID profile_id;

    public InstitutionalCoordinator asInstitutionalCoordinator() {
        return new InstitutionalCoordinator(
            (this.id == null) ? null : UUID.randomUUID(),
            new InstitutionalCoordinatorDegree(this.degree),
            new Profile(this.profile_id, null, null, null, null, null)
        );
    }
}
