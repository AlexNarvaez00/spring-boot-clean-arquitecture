package mx.edu.itoaxaca.api.v1.syllabus.application;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.syllabus.domain.SyllabusRepository;

public class SyllabusDelete {

    public static void run(SyllabusRepository repo, UUID id) {
        repo.deleteById(id);
    }
}
