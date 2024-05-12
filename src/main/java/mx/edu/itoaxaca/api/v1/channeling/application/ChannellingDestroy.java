package mx.edu.itoaxaca.api.v1.channeling.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.channeling.domain.ChannellingRepository;

public class ChannellingDestroy {
    public static void run(ChannellingRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
