package mx.edu.itoaxaca.api.v1.syllabus.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.syllabus.domain.Syllabus;
import mx.edu.itoaxaca.api.v1.syllabus.domain.SyllabusRepository;

public class SyllabusGetById {

    public static Syllabus run(SyllabusRepository repo, UUID id) {
        return repo.findSyllabusById(id);
    }
}
