package mx.edu.itoaxaca.api.v1.groups.domain;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.itoaxaca.api.v1.comments_evaluation_group.domain.CommentEvaluationGroup;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestamps;

@Data
@Entity
@Table(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
public class Group extends WithTimestamps{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    @Convert(converter = GroupNameConverter.class)
    private GroupName name;

    @Column(name = "code", nullable = false)
    @Convert(converter = GroupCodeConverter.class)
    private GroupCode code;

    @OneToMany(mappedBy = "group")
    private List<CommentEvaluationGroup> comments;

    public Group(UUID id, GroupName name, GroupCode code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
}
