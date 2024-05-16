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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mx.edu.itoaxaca.api.v1.shared.domain.WithTimestamps;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "periods")
@NoArgsConstructor
public class Period extends WithTimestamps{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "start_date", nullable = false)
    @Convert(converter = PeriodStartDateConverter.class)
    private PeriodStartDate startDate;

    @Column(name = "end_date", nullable = false)
    @Convert(converter = PeriodEndDateConverter.class)
    private PeriodEndDate endDate;

    @Column(name = "current", nullable = false)
    @Convert(converter = PeriodCurrentConverter.class)
    private PeriodCurrent current;

    public Period(
        UUID id,
        PeriodStartDate startDate,
        PeriodEndDate endDate,
        PeriodCurrent current
    ) {
        super();
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.current = current;
    }
}
