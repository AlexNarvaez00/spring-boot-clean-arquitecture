package mx.edu.itoaxaca.api.v1.channeling_follow_up.application;

import mx.edu.itoaxaca.api.v1.channeling_follow_up.domain.ChannellingFollowUp;
import mx.edu.itoaxaca.api.v1.channeling_follow_up.domain.ChannellingFollowUpRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ChannellingFollowUpGetAll {
    public static Page<ChannellingFollowUp> run(Pageable pageable, ChannellingFollowUpRepository repo) {
        return repo.findAll(pageable);
    }
}
