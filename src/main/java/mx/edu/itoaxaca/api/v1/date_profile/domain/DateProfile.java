package mx.edu.itoaxaca.api.v1.date_profile.domain;

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
import mx.edu.itoaxaca.api.v1.date.domain.Date;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Data
@Entity
@Table(name = "date_profiles")
@NoArgsConstructor
public class DateProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "date_id", nullable = false)
    @JsonIgnore
    private Date date;

    @ManyToOne
    @JoinColumn(name = "host_id", nullable = false)
    @JsonIgnore
    private Profile host;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    @JsonIgnore
    private Profile guest;

    public DateProfile(UUID id, Date date, Profile host, Profile guest) {
        this.id = id;
        this.date = date;
        this.host = host;
        this.guest = guest;
    }
}
