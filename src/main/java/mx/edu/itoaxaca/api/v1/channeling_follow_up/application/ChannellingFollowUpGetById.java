package mx.edu.itoaxaca.api.v1.channeling_follow_up.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.channeling_follow_up.domain.ChannellingFollowUp;
import mx.edu.itoaxaca.api.v1.channeling_follow_up.domain.ChannellingFollowUpRepository;

public class ChannellingFollowUpGetById {
    public static ChannellingFollowUp run(ChannellingFollowUpRepository repo, UUID id) {
        return repo.findChannellingFollowUpById(id);
    }
}
