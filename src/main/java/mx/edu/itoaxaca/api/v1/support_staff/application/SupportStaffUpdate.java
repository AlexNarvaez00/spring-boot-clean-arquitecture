package mx.edu.itoaxaca.api.v1.support_staff.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaff;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaffRepository;

public class SupportStaffUpdate {
    public static SupportStaff run(
        SupportStaffRepository repo,
        UUID id,
        SupportStaff arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
