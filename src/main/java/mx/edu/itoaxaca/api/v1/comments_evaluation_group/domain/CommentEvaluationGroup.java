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
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@NoArgsConstructor
@Table(name = "comments_evaluation_groups")
public class CommentEvaluationGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "comment")
    @Convert(converter = CommentEvaluationGroupCommentConverter.class)
    private CommentEvaluationGroupComment comment;

    @Column(name = "created_at")
    @CreatedDate
    @Convert(converter = CommentEvaluationGroupCreatedAtConverter.class)
    private CommentEvaluationGroupCreatedAt createdAt;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    @JsonIgnore
    private Group group;

    public CommentEvaluationGroup(
        UUID id,
        CommentEvaluationGroupComment comment,
        CommentEvaluationGroupCreatedAt createdAt,
        Group group
    ) {
        this.id = id;
        this.comment = comment;
        this.createdAt = createdAt;
        this.group = group;
    }
}
