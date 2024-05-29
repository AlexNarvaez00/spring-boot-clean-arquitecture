package mx.edu.itoaxaca.api.v1.support_staff.domain;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Data;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportArea;

@Setter
public class SupportStaffStoreRequest {

    private UUID id;

    @NotNull
    private String job_title;

    @NotNull
    private UUID support_area_id;

    @NotNull
    private UUID profile_id;

    public SupportStaff asSupportStaff() {
        return new SupportStaff(
            (this.id == null) ? null : UUID.randomUUID(),
            new SupportStaffJobTitle(this.job_title),
            new SupportArea(this.support_area_id, null, null),
            new Profile(this.profile_id, null, null, null, null)
        );
    }
}
