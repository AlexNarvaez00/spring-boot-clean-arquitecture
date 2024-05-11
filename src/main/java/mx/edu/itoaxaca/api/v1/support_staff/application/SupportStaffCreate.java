package mx.edu.itoaxaca.api.v1.support_staff.application;

import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaff;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaffRepository;

public class SupportStaffCreate {
    public static SupportStaff run(SupportStaffRepository repo, SupportStaff arg) {
        return repo.save(arg);
    }
}
