package mx.edu.itoaxaca.api.v1.departamental_coordinator.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Data
@Entity
@Table(name = "departamental_coordinators")
@NoArgsConstructor
public class DepartamentalCoordinator {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "degree", nullable = false)
    @Convert(converter = DepartamentalCoordinatorDegreeConverter.class)
    private DepartamentalCoordinatorDegree degree;

    @OneToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id", nullable = false)
    private Profile profile;

    public DepartamentalCoordinator(
        UUID id,
        DepartamentalCoordinatorDegree degree,
        Profile profile
    ) {
        this.id = id;
        this.degree = degree;
        this.profile = profile;
    }
}
