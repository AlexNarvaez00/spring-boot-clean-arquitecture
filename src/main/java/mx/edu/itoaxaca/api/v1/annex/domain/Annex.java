package mx.edu.itoaxaca.api.v1.annex.domain;

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
@Table(name = "annexs")
@NoArgsConstructor
public class Annex {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    @Convert(converter = AnnexNameConverter.class)
    private AnnexName name;
    
    @Column(name = "body", nullable = false)
    @Convert(converter = AnnexBodyConverter.class)
    private AnnexBody body;

    public Annex(UUID id, AnnexName name, AnnexBody body) {
        this.id = id;
        this.name = name;
        this.body = body;
    }
}
