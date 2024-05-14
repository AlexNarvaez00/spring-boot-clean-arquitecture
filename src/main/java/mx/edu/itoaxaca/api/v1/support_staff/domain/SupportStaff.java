package mx.edu.itoaxaca.api.v1.support_staff.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestamps;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportArea;

@Data
@Entity
@Table(name = "support_staffs")
@NoArgsConstructor
public class SupportStaff extends WithTimestamps{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "job_title", nullable = false)
    @Convert(converter = SupportStaffJobTitleConverter.class)
    private SupportStaffJobTitle jobTitle;

    @ManyToOne
    @JoinColumn(name = "support_area", nullable = false)
    private SupportArea supportArea;

    @OneToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id", nullable = false)
    private Profile profile;

    public SupportStaff(
        UUID id,
        SupportStaffJobTitle jobTitle,
        SupportArea supportArea,
        Profile profile
    ) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.supportArea = supportArea;
        this.profile = profile;
    }
}
