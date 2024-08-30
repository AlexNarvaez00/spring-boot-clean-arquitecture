package mx.edu.itoaxaca.api.v1.support_area.domain;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.PostgresTypeSupportArea;

@Setter
public class SupportAreaUpdateRequest {

    @NotNull
    private String name;

    @NotNull
    private String short_name;

    @NotNull
    private UUID type_support_area_id;

    public SupportArea asSupportArea() {
        return new SupportArea(
            null,
            new SupportAreaName(this.name),
            new SupportAreaShortName(this.short_name),
            new PostgresTypeSupportArea(this.type_support_area_id, null)
        );
    }
}
