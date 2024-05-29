package mx.edu.itoaxaca.api.v1.support_staff.domain;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.profile.domain.ProfileMother;
import mx.edu.itoaxaca.api.v1.shared.FakerService;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportArea;

public class SupportStaffMother {

    public static SupportStaff random() {
        var faker = FakerService.create();
        return new SupportStaff(
            UUID.randomUUID(),
            new SupportStaffJobTitle(faker.name().firstName()),
            new SupportArea(UUID.randomUUID(), null, null),
            ProfileMother.random()
        );
    }
}
