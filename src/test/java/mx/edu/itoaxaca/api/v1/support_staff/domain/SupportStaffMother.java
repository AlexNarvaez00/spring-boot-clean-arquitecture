package mx.edu.itoaxaca.api.v1.support_staff.domain;

import java.util.UUID;

public class SupportStaffMother {

    public static SupportStaff random() {
        return new SupportStaff(
            UUID.randomUUID()
        );
    }
}
