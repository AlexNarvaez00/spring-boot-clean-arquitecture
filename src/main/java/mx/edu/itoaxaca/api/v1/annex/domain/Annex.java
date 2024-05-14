package mx.edu.itoaxaca.api.v1.annex.domain;

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
import mx.edu.itoaxaca.api.v1.activity.domain.Activity;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestamps;

@Data
@Entity
@Table(name = "annexs")
@NoArgsConstructor
public class Annex extends WithTimestamps{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    @Convert(converter = AnnexNameConverter.class)
    private AnnexName name;
    
    @Column(name = "body", nullable = false)
    @Convert(converter = AnnexBodyConverter.class)
    private AnnexBody body;

    @OneToMany(mappedBy = "annex")
    @JsonIgnore
    private List<Activity> activities;

    public Annex(UUID id, AnnexName name, AnnexBody body) {
        this.id = id;
        this.name = name;
        this.body = body;
    }
}
