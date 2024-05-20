package mx.edu.itoaxaca.api.v1.profile.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mx.edu.itoaxaca.api.v1.departament.domain.Departament;
import mx.edu.itoaxaca.api.v1.departament_teacher.domain.DepartamentTeacher;
import mx.edu.itoaxaca.api.v1.departamental_coordinator.domain.DepartamentalCoordinator;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.domain.InstitutionalCoordinator;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestamps;
import mx.edu.itoaxaca.api.v1.student.domain.Student;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaff;
import mx.edu.itoaxaca.api.v1.teacher.domain.Teacher;
import mx.edu.itoaxaca.api.v1.tutor.domain.Tutor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "profiles")
@EqualsAndHashCode(callSuper = false)
public class Profile extends WithTimestamps {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    @Convert(converter = ProfileNameConverter.class)
    private ProfileName name;

    @Column(name = "email", nullable = false)
    @Convert(converter = ProfileEmailConverter.class)
    private ProfileEmail email;

    @Column(name = "password", nullable = false)
    @Convert(converter = ProfilePasswordConverter.class)
    private ProfilePassword password;

    @Column(name = "last_session", nullable = true)
    @Convert(converter = ProfileLastSessionConverter.class)
    private ProfileLastSession lastSession;

    @OneToOne(mappedBy = "profile")
    @JsonIgnore
    private InstitutionalCoordinator institutionalCoordinator;

    @OneToOne(mappedBy = "profile")
    @JsonIgnore
    private Tutor tutor;

    @OneToOne(mappedBy = "profile")
    @JsonIgnore
    private SupportStaff supportStaff;

    @OneToOne(mappedBy = "profile")
    @JsonIgnore
    private Student student;

    @OneToOne(mappedBy = "profile")
    @JsonIgnore
    private Teacher teacher;

    @OneToOne(mappedBy = "departamentCoordinator")
    @JsonIgnore
    private Departament departament;

    @OneToOne(mappedBy = "profile")
    @JsonIgnore
    private DepartamentalCoordinator departamentalCoordinator;

    @OneToOne(mappedBy = "teacher")
    @JsonIgnore
    private DepartamentTeacher departamentTeacher;

    public Profile(
        UUID id,
        ProfileName name,
        ProfileEmail email,
        ProfilePassword password,
        ProfileLastSession lastSession
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.lastSession = lastSession;
    }
}
