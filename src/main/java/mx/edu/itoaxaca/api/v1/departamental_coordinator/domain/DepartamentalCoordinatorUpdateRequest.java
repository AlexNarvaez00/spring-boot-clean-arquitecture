package mx.edu.itoaxaca.api.v1.departamental_coordinator.domain;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Data
public class DepartamentalCoordinatorUpdateRequest {
    
    @NotNull
    private String name;
    
    @NotNull
    private UUID profile_id;
    
    public DepartamentalCoordinator asDepartamentalCoordinator() {
        return new DepartamentalCoordinator(
            null,
            new DepartamentalCoordinatorDegree(this.name),
            new Profile(profile_id, null, null, null, null, null)
        );
    }
}
