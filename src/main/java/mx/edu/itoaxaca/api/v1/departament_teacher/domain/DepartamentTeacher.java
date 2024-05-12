package mx.edu.itoaxaca.api.v1.departament_teacher.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.itoaxaca.api.v1.departament.domain.Departament;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Data
@Entity
@Table(name = "departament_teachers")
@NoArgsConstructor
public class DepartamentTeacher {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
    private Profile teacher;

    @ManyToOne
    @JoinColumn(name = "departementa_id", nullable = false)
    @JsonIgnore
    private Departament departament;

    public DepartamentTeacher(UUID id, Profile teacher, Departament departament) {
        this.id = id;
        this.teacher = teacher;
        this.departament = departament;
    }
}
