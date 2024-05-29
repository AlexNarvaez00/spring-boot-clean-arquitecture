package mx.edu.itoaxaca.api.v1.support_area.domain;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportArea;


@Setter
public class SupportAreaStoreRequest {

    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String short_name;

    @NotNull
    private UUID type_support_area_id;

    public SupportArea asSupportArea() {
        return new SupportArea(
            (this.id == null) ? null : UUID.randomUUID(),
            new SupportAreaName(this.name),
            new SupportAreaShortName(this.short_name),
            new TypeSupportArea(this.type_support_area_id, null)
        );
    }
}
