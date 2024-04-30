package mx.edu.itoaxaca.api.v1.shedule.domain;

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
@Table(name = "shedules")
@NoArgsConstructor
public class Shedule {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "start_hour", nullable = false)
    @Convert(converter = SheduleStartHourConverter.class)
    private SheduleStartHour startHour;

    @Column(name = "end_hour", nullable = false)
    @Convert(converter = SheduleEndHourConverter.class)
    private SheduleEndHour endHour;

    @Column(name = "day", nullable = false)
    @Convert(converter = SheduleDayConverter.class)
    private SheduleDay day;

    public Shedule(
        UUID id,
        SheduleStartHour startHour,
        SheduleEndHour endHour,
        SheduleDay day
    ) {
        this.id = id;
        this.startHour = startHour;
        this.endHour = endHour;
        this.day = day;
    }
}
