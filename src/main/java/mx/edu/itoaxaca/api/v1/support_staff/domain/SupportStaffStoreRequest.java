package mx.edu.itoaxaca.api.v1.support_staff.domain;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;

@Data
public class SupportStaffStoreRequest {
    private UUID id;

    @NotNull
    private String job_title;

    @NotNull
    private UUID profile_id;

    public SupportStaff asSupportStaff() {
        return new SupportStaff(
            (this.id == null) ? null : UUID.randomUUID(),
            new SupportStaffJobTitle(this.job_title),
            new Profile(this.profile_id, null, null, null, null, null)
        );
    }
}
