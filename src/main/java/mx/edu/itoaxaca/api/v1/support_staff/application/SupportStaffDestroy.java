package mx.edu.itoaxaca.api.v1.support_staff.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaffRepository;

public class SupportStaffDestroy {
    public static void run(SupportStaffRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
