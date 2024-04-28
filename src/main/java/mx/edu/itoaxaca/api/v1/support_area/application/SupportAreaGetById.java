package mx.edu.itoaxaca.api.v1.support_area.application;

import java.util.UUID;

import mx.edu.itoaxaca.api.v1.support_area.domain.SupportArea;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportAreaRepository;

public class SupportAreaGetById {

    public static SupportArea run(SupportAreaRepository repo, UUID id) {
        return repo.findSupportAreaById(id);
    }
}
