package mx.edu.itoaxaca.api.v1.support_staff.application;

import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaff;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaffRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class SupportStaffGetAll {
    public static Page<SupportStaff> run(Pageable pageable, SupportStaffRepository repo) {
        return repo.findAll(pageable);
    }
}
