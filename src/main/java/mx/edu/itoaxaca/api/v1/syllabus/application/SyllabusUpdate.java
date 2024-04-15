package mx.edu.itoaxaca.api.v1.syllabus.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.syllabus.domain.Syllabus;
import mx.edu.itoaxaca.api.v1.syllabus.domain.SyllabusRepository;

public class SyllabusUpdate {

    public static Syllabus run(SyllabusRepository repo, UUID id, Syllabus syllabus) {
        syllabus.setId(id);
        return repo.save(syllabus);
    }
}
