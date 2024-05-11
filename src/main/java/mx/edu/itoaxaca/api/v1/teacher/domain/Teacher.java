package mx.edu.itoaxaca.api.v1.teacher.domain;

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
@Table(name = "teachers")
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "type", nullable = false)
    @Convert(converter = TeacherTypeConverter.class)
    private TeacherType type;
    
    @OneToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id", nullable = false)
    private Profile profile;
    
    public Teacher(UUID id, TeacherType type, Profile profile) {
        this.id = id;
        this.type = type;
        this.profile = profile;
    }
}
