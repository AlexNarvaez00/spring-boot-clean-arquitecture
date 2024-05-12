package mx.edu.itoaxaca.api.v1.channeling.application;

import mx.edu.itoaxaca.api.v1.channeling.domain.Channelling;
import mx.edu.itoaxaca.api.v1.channeling.domain.ChannellingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ChannellingGetAll {
    public static Page<Channelling> run(Pageable pageable, ChannellingRepository repo) {
        return repo.findAll(pageable);
    }
}
