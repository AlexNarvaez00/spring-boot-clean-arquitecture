package mx.edu.itoaxaca.api.v1.career.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import mx.edu.itoaxaca.api.v1.departament.domain.Departament;

@Entity
@Table(name = "careers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    @Convert(converter = CareerNameConverter.class)
    private CareerName name;

    @ManyToOne
    @JoinColumn(name = "departament_id")
    @JsonIgnore
    private Departament departament;
}
