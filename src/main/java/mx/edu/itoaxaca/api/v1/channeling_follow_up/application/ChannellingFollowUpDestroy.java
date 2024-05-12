package mx.edu.itoaxaca.api.v1.channeling_follow_up.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.channeling_follow_up.domain.ChannellingFollowUpRepository;

public class ChannellingFollowUpDestroy {
    public static void run(ChannellingFollowUpRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
