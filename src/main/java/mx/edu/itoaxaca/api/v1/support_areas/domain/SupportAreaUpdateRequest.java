package mx.edu.itoaxaca.api.v1.support_areas.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SupportAreaUpdateRequest {

    @NotNull
    private String name;

    @NotNull
    private String short_name;

    public SupportArea asSupportArea() {
        return new SupportArea(
            null,
            new SupportAreaName(this.name),
            new SupportAreaShortName(this.short_name)
        );
    }
}
