package mx.edu.itoaxaca.api.v1.type_date.domain;

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
import mx.edu.itoaxaca.api.v1.date.domain.Date;

@Data
@Entity
@Table(name = "type_dates")
@NoArgsConstructor
public class TypeDate {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    @Convert(converter = TypeDateNameConverter.class)
    private TypeDateName name;

    @OneToMany(mappedBy = "typeDate")
    @JsonIgnore
    private List<Date> dates;

    public TypeDate(UUID id, TypeDateName name) {
        this.id = id;
        this.name = name;
    }
}
