package mx.edu.itoaxaca.api.v1.departament.domain;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "departaments")
@Data
public class Departament {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Nonnull
    public UUID id;

    @Column(name = "name", nullable = false)
    public String name;

    public Departament(String name) {
        this.name = name;
    }
}
