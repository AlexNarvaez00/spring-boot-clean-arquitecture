package mx.edu.itoaxaca.api.v1.support_area.application;

import mx.edu.itoaxaca.api.v1.support_area.domain.SupportArea;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportAreaRepository;

public class SupportAreaCreate {

    public static SupportArea run(SupportAreaRepository repo, SupportArea supportArea) {
        return repo.save(supportArea);
    }
}
