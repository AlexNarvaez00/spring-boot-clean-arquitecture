package mx.edu.itoaxaca.api.v1.comment_evaluation.domain;

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
import mx.edu.itoaxaca.api.v1.career.domain.Career;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestamps;

@Data
@Entity
@Table(name = "comment_evaluations")
@NoArgsConstructor
public class CommentEvaluation extends WithTimestamps {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    @Convert(converter = CommentEvaluationCommentConverter.class)
    private CommentEvaluationComment name;

    @ManyToOne
    @JoinColumn(name = "creer_id", nullable = false)
    private Career career;

    public CommentEvaluation(UUID id, CommentEvaluationComment name, Career career) {
        this.id = id;
        this.name = name;
        this.career = career;
    }
}
