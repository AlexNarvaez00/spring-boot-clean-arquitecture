package mx.edu.itoaxaca.api.v1.channeling.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.itoaxaca.api.v1.channeling_follow_up.domain.ChannellingFollowUp;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestamps;

@Data
@Entity
@Table(name = "channelings")
@NoArgsConstructor
public class Channelling extends WithTimestamps{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "comment", nullable = false)
    @Convert(converter = ChannellingCommentConverter.class)
    private ChannellingComment comment;

    @Column(name = "date", nullable = false)
    @Convert(converter = ChannellingDateConverter.class)
    private ChannellingDate date;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    @JsonIgnore
    private Profile tutor;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @JsonIgnore
    private Profile student;

    @ManyToOne
    @JoinColumn(name = "support_staff_id", nullable = false)
    @JsonIgnore
    private Profile supportStaff;

    @OneToMany(mappedBy = "channelling")
    @JsonIgnore
    private List<ChannellingFollowUp> channellingFollowUps; 

    public Channelling(
        UUID id,
        ChannellingComment comment,
        ChannellingDate date,
        Profile tutor,
        Profile student,
        Profile supportStaff
    ) {
        this.id = id;
        this.comment = comment;
        this.date = date;
        this.tutor = tutor;
        this.student = student;
        this.supportStaff = supportStaff;
    }
}
