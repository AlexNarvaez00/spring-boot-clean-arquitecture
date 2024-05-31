package mx.edu.itoaxaca.api.v1.departamental_coordinator.domain;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Setter
public class DepartamentalCoordinatorStoreRequest {

    private UUID id;

    @NotNull
    private String degree;

    @NotNull
    private UUID profile_id;

    public DepartamentalCoordinator asDepartamentalCoordinator() {
        return new DepartamentalCoordinator(
            (this.id == null) ? null : UUID.randomUUID(),
            new DepartamentalCoordinatorDegree(this.degree),
            new Profile(profile_id, null, null, null, null)
        );
    }
}
