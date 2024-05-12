package mx.edu.itoaxaca.api.v1.follow_up.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.itoaxaca.api.v1.channeling_follow_up.domain.ChannellingFollowUp;

@Data
@Entity
@Table(name = "follow_ups")
@NoArgsConstructor
public class FollowUp {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "comment", nullable = false, columnDefinition = "TEXT")
    @Convert(converter = FollowUpCommentConverter.class)
    private FollowUpComment comment;

    @Column(name = "confirm", nullable = false)
    @Convert(converter = FollowUpConfirmConverter.class)
    private FollowUpConfirm confirm;
    
    @Column(name = "callOn", nullable = false)
    @Convert(converter = FollowUpCallOnConverter.class)
    private FollowUpCallOn callOn;
    
    @OneToMany(mappedBy = "followUp")
    @JsonIgnore
    private List<ChannellingFollowUp> channellingFollowUps;
    
    public FollowUp(UUID id, FollowUpComment comment, FollowUpConfirm confirm, FollowUpCallOn callOn) {
        this.id = id;
        this.comment = comment;
        this.confirm = confirm;
        this.callOn = callOn;
    }
}
