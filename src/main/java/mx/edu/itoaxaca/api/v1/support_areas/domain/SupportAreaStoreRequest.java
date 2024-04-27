package mx.edu.itoaxaca.api.v1.support_areas.domain;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SupportAreaStoreRequest {

    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String short_name;

    public SupportArea asSupportArea() {
        return new SupportArea(
            (this.id == null) ? null : UUID.randomUUID(),
            new SupportAreaName(this.name),
            new SupportAreaShortName(this.short_name)
        );
    }
}
