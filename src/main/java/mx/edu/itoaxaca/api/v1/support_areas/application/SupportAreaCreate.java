package mx.edu.itoaxaca.api.v1.support_areas.application;

import mx.edu.itoaxaca.api.v1.support_areas.domain.SupportArea;
import mx.edu.itoaxaca.api.v1.support_areas.domain.SupportAreaRepository;

public class SupportAreaCreate {

    public static SupportArea run(SupportAreaRepository repo, SupportArea supportArea) {
        return repo.save(supportArea);
    }
}
