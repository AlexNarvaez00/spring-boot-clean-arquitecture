package mx.edu.itoaxaca.api.v1.date.domain;

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
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDate;

@Data
@Entity
@Table(name = "dates")
@NoArgsConstructor
public class Date {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "link", nullable = false)
    @Convert(converter = DateLinkConverter.class)
    private DateLink link;

    @Column(name = "date", nullable = false)
    @Convert(converter = DateDateConverter.class)
    private DateDate date;

    @Column(name = "confirm", nullable = false)
    @Convert(converter = DateConfirmConverter.class)
    private DateConfirm confirm;

    @ManyToOne()
    @JoinColumn(name = "type_date_id", nullable = false)
    private TypeDate typeDate;

    public Date(UUID id, DateLink link, DateDate date, DateConfirm confirm, TypeDate typeDate) {
        this.id = id;
        this.link = link;
        this.date = date;
        this.confirm = confirm;
        this.typeDate = typeDate;
    }
}
