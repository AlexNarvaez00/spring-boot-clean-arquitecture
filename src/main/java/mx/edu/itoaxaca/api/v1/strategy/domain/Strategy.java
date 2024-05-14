package mx.edu.itoaxaca.api.v1.strategy.domain;

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
import mx.edu.itoaxaca.api.v1.activity_institutional_mentoring_program.domain.ActivityInstitutionalMentoringProgram;
import mx.edu.itoaxaca.api.v1.institutional_mentoring_program.domain.InstitutionalMentoringProgram;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestamps;

@Data
@Entity
@Table(name = "strategies")
@NoArgsConstructor
public class Strategy extends WithTimestamps{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    @Convert(converter = StrategyNameConverter.class)
    private StrategyName name;

    @ManyToOne
    @JoinColumn(name = "institutional_mentoring_program_id")
    @JsonIgnore
    private InstitutionalMentoringProgram institutionalMentoringProgram;

    @OneToMany(mappedBy = "strategy")
    @JsonIgnore
    private List<
        ActivityInstitutionalMentoringProgram
    > activityInstitutionalMentoringProgram;

    public Strategy(
        UUID id,
        StrategyName name,
        InstitutionalMentoringProgram institutionalMentoringProgram
    ) {
        this.id = id;
        this.name = name;
        this.institutionalMentoringProgram = institutionalMentoringProgram;
    }
}
