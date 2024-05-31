package mx.edu.itoaxaca.api.v1.date.domain;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.type_date.domain.TypeDate;
import org.hibernate.validator.constraints.URL;

@Setter
public class DateStoreRequest {

    private UUID id;

    @NotNull
    @URL
    private String link;

    @NotNull
    private LocalDateTime date;

    @NotNull
    private Boolean confirm;

    @NotNull
    private UUID type_date_id;

    public Date asDate() {
        return new Date(
            (this.id == null) ? null : UUID.randomUUID(),
            new DateLink(this.link),
            new DateDate(this.date),
            new DateConfirm(this.confirm),
            new TypeDate(this.type_date_id, null)
        );
    }
}
