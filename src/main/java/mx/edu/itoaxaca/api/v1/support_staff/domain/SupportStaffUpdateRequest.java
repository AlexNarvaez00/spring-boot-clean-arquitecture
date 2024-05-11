package mx.edu.itoaxaca.api.v1.support_staff.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SupportStaffUpdateRequest {
    
    @NotNull
    private String jobTitle;

    public SupportStaff asSupportStaff() {
        return new SupportStaff(
            null,
            new SupportStaffJobTitle(this.jobTitle)
        );
    }
}
