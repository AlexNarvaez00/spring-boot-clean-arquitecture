package mx.edu.itoaxaca.api.v1.profile.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.itoaxaca.api.v1.institutional_coordinator.domain.InstitutionalCoordinator;
import mx.edu.itoaxaca.api.v1.student.domain.Student;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaff;
import mx.edu.itoaxaca.api.v1.tutor.domain.Tutor;

@Data
@Entity
@Table(name = "profiles")
@NoArgsConstructor
public class Profile {

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

    @Column(name = "created_at", nullable = false)
    @Convert(converter = ProfileCreatedAtConverter.class)
    private ProfileCreatedAt createdAt;

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
    
    public Profile(
        UUID id,
        ProfileName name,
        ProfileEmail email,
        ProfilePassword password,
        ProfileCreatedAt createdAt,
        ProfileLastSession lastSession
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.lastSession = lastSession;
    }
}
