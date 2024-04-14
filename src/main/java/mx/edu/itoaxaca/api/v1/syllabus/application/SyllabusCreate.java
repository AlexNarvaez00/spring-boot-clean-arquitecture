package mx.edu.itoaxaca.api.v1.syllabus.application;

import mx.edu.itoaxaca.api.v1.syllabus.domain.Syllabus;
import mx.edu.itoaxaca.api.v1.syllabus.domain.SyllabusRepository;

public class SyllabusCreate {

    public static Syllabus run(SyllabusRepository repo, Syllabus syllabus) {
        return repo.save(syllabus);
    }
}
