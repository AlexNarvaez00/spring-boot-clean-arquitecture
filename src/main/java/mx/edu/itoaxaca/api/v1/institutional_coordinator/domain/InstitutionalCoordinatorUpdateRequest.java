package mx.edu.itoaxaca.api.v1.institutional_coordinator.domain;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Setter
public class InstitutionalCoordinatorUpdateRequest {

    @NotNull
    private String degree;

    @NotNull
    private UUID profile_id;
    
    public InstitutionalCoordinator asInstitutionalCoordinator() {
        return new InstitutionalCoordinator(
            null,
            new InstitutionalCoordinatorDegree(this.degree),
            new Profile(this.profile_id, null, null, null, null)
        );
    }
}
