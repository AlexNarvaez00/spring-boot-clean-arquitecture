package mx.edu.itoaxaca.api.v1.channeling_follow_up.domain;

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
import mx.edu.itoaxaca.api.v1.channeling.domain.Channelling;
import mx.edu.itoaxaca.api.v1.follow_up.domain.FollowUp;

@Data
@Entity
@Table(name = "channeling_follow_ups")
@NoArgsConstructor
public class ChannellingFollowUp {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "channeling_id", nullable = false)
    @JsonIgnore
    private Channelling channelling;

    @ManyToOne
    @JoinColumn(name = "follow_up_id", nullable = false)
    @JsonIgnore
    private FollowUp followUp;

    public ChannellingFollowUp(UUID id, Channelling channelling, FollowUp followUp) {
        this.id = id;
        this.channelling = channelling;
        this.followUp = followUp;
    }
}
