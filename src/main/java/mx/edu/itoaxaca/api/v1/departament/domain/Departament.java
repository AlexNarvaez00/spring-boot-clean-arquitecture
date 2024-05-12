package mx.edu.itoaxaca.api.v1.departament.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.itoaxaca.api.v1.career.domain.Career;
import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacher;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Entity
@Table(name = "departaments")
@Data
@NoArgsConstructor
public class Departament {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    @Convert(converter = DepartamenteNameConvert.class)
    private DepartamentName name;

    @OneToOne
    @JoinColumn(
        name = "departament_coordinator_id",
        referencedColumnName = "id",
        nullable = false
    )
    private Profile departamentCoordinator;

    @OneToMany(mappedBy = "departament")
    private List<Career> careers;

    @OneToMany(mappedBy = "departament")
    private List<DepartamentTeacher> teachers;

    public Departament(UUID id, DepartamentName name) {
        this.id = id;
        this.name = name;
    }
}
