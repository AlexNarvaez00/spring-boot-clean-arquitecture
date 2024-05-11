package mx.edu.itoaxaca.api.v1.support_staff.domain;

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
@Table(name = "support_staffs")
@NoArgsConstructor
public class SupportStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "job_title", nullable = false)
    @Convert(converter = SupportStaffJobTitleConverter.class)
    private SupportStaffJobTitle jobTitle;

    @OneToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id", nullable = false)
    private Profile profile;

    public SupportStaff(UUID id, SupportStaffJobTitle jobTitle) {
        this.id = id;
        this.jobTitle = jobTitle;
    }

    public SupportStaff(UUID id, SupportStaffJobTitle jobTitle, Profile profile) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.profile = profile;
    }
}
