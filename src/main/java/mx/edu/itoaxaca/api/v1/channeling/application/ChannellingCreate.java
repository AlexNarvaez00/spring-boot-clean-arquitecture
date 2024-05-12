package mx.edu.itoaxaca.api.v1.channeling.application;

import mx.edu.itoaxaca.api.v1.channeling.domain.Channelling;
import mx.edu.itoaxaca.api.v1.channeling.domain.ChannellingRepository;

public class ChannellingCreate {
    public static Channelling run(ChannellingRepository repo, Channelling arg) {
        return repo.save(arg);
    }
}
