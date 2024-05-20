package mx.edu.itoaxaca.api.v1.shared.domain;

import mx.edu.itoaxaca.api.v1.shared.FakerService;

public class EmailMother {

    public static String random() {
        return FakerService.create().internet().emailAddress();
    }
}
