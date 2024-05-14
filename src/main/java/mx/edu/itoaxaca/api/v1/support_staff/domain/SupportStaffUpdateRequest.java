package mx.edu.itoaxaca.api.v1.support_staff.domain;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Data;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportArea;

@Data
public class SupportStaffUpdateRequest {

    @NotNull
    private String jobTitle;

    @NotNull
    private UUID support_area_id;

    @NotNull
    private UUID profile_id;

    public SupportStaff asSupportStaff() {
        return new SupportStaff(
            null,
            new SupportStaffJobTitle(this.jobTitle),
            new SupportArea(support_area_id, null, null, null),
            new Profile(profile_id, null, null, null, null)
        );
    }
}
