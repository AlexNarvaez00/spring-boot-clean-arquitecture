package mx.edu.itoaxaca.api.v1.channeling.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.channeling.domain.Channelling;
import mx.edu.itoaxaca.api.v1.channeling.domain.ChannellingRepository;

public class ChannellingUpdate {
    public static Channelling run(
        ChannellingRepository repo,
        UUID id,
        Channelling arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
