package mx.edu.itoaxaca.api.v1.date.domain;

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

    public Date(UUID id, DateLink link, DateDate date, DateConfirm confirm) {
        this.id = id;
        this.link = link;
        this.date = date;
        this.confirm = confirm;
    }
}
