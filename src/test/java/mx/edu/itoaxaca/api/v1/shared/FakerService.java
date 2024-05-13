package mx.edu.itoaxaca.api.v1.shared;

import com.github.javafaker.Faker;

public class FakerService {

    public static Faker create() {
        Faker fake = new Faker();
        return fake;
    }
}
