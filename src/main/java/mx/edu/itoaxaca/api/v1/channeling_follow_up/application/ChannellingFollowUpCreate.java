package mx.edu.itoaxaca.api.v1.channeling_follow_up.application;

import mx.edu.itoaxaca.api.v1.channeling_follow_up.domain.ChannellingFollowUp;
import mx.edu.itoaxaca.api.v1.channeling_follow_up.domain.ChannellingFollowUpRepository;

public class ChannellingFollowUpCreate {
    public static ChannellingFollowUp run(ChannellingFollowUpRepository repo, ChannellingFollowUp arg) {
        return repo.save(arg);
    }
}
