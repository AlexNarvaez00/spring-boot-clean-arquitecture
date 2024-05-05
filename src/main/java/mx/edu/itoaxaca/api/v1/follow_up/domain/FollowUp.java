package mx.edu.itoaxaca.api.v1.follow_up.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public FollowUp(UUID id, FollowUpComment comment, FollowUpConfirm confirm, FollowUpCallOn callOn) {
        this.id = id;
        this.comment = comment;
        this.confirm = confirm;
        this.callOn = callOn;
    }
}
