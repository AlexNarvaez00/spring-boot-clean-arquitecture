package mx.edu.itoaxaca.api.v1.support_area.domain;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportArea;

@Data
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
            new TypeSupportArea(this.type_support_area_id, null)
        );
    }
}
