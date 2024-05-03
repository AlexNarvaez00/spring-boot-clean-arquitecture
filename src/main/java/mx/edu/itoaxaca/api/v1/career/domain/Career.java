package mx.edu.itoaxaca.api.v1.career.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.itoaxaca.api.v1.action_plan.domain.ActionPlan;
import mx.edu.itoaxaca.api.v1.departament.domain.Departament;
import mx.edu.itoaxaca.api.v1.workshop.domain.Workshop;

@Entity
@Table(name = "careers")
@Data
@NoArgsConstructor
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    @Convert(converter = CareerNameConverter.class)
    private CareerName name;

    @ManyToOne
    @JoinColumn(name = "departament_id")
    @JsonIgnore
    private Departament departament;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
        name = "career_workshops",
        joinColumns = { @JoinColumn(name = "career_id") },
        inverseJoinColumns = { @JoinColumn(name = "workshop_id") }
    )
    private List<Workshop> workshops;

    @OneToMany(mappedBy = "career")
    @JsonIgnore
    private List<ActionPlan> actionsPlans;

    public Career(UUID id, CareerName name, Departament departament) {
        this.id = id;
        this.name = name;
        this.departament = departament;
    }
}
