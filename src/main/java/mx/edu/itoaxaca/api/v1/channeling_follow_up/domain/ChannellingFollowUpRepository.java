package mx.edu.itoaxaca.api.v1.channeling_follow_up.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChannellingFollowUpRepository {
    ChannellingFollowUp save(ChannellingFollowUp arg);
    Page<ChannellingFollowUp> findAll(Pageable pageable);
    void deleteById(UUID id);
    ChannellingFollowUp findChannellingFollowUpById(UUID id);
}
