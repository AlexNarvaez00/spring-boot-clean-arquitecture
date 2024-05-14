package mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
import mx.edu.itoaxaca.api.v1.groups.domain.Group;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestamps;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@NoArgsConstructor
@Table(name = "comments_evaluation_groups")
public class CommentEvaluationGroup extends WithTimestamps{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "comment")
    @Convert(converter = CommentEvaluationGroupCommentConverter.class)
    private CommentEvaluationGroupComment comment;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    @JsonIgnore
    private Group group;

    public CommentEvaluationGroup(
        UUID id,
        CommentEvaluationGroupComment comment,
        Group group
    ) {
        this.id = id;
        this.comment = comment;
        this.group = group;
    }
}
