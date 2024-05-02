package mx.edu.itoaxaca.api.v1.date.domain;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DateUpdateRequest {

    @NotNull
    @URL
    private String link;

    @NotNull
    private LocalDateTime date;

    @NotNull
    private Boolean confirm;

    public Date asDate() {
        return new Date(
            null,
            new DateLink(this.link),
            new DateDate(this.date),
            new DateConfirm(this.confirm)
        );
    }
}
