package mx.edu.itoaxaca.api.v1.channeling_follow_up.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.channeling_follow_up.domain.ChannellingFollowUp;
import mx.edu.itoaxaca.api.v1.channeling_follow_up.domain.ChannellingFollowUpRepository;

public class ChannellingFollowUpUpdate {
    public static ChannellingFollowUp run(
        ChannellingFollowUpRepository repo,
        UUID id,
        ChannellingFollowUp arg
    ) {
        arg.setId(id);
        return repo.save(arg);
    }
}
