package mx.edu.itoaxaca.api.v1.group_tutor_student.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.itoaxaca.api.v1.groups.domain.Group;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Data
@Entity
@Table(name = "group_tutor_students")
@NoArgsConstructor
public class GroupTutorStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    @JsonIgnore
    private Group group;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    @JsonIgnore
    private Profile tutor;

    @ManyToOne
    @JoinColumn(name = "student", nullable = false)
    private Profile student;

    public GroupTutorStudent(UUID id, Group group, Profile tutor, Profile student) {
        this.id = id;
        this.group = group;
        this.tutor = tutor;
        this.student = student;
    }
}
