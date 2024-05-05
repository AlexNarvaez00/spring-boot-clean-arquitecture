package mx.edu.itoaxaca.api.v1.period.domain;

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
@Table(name = "periods")
@NoArgsConstructor
public class Period {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "start_date", nullable = false)
    @Convert(converter = PeriodStartDateConverter.class)
    private PeriodStartDate startDate;

    @Column(name = "end_date", nullable = false)
    @Convert(converter = PeriodEndDateConverter.class)
    private PeriodEndDate endDate;

    public Period(UUID id, PeriodStartDate startDate, PeriodEndDate endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
