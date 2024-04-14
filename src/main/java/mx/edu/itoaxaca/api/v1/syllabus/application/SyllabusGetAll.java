package mx.edu.itoaxaca.api.v1.syllabus.application;

import mx.edu.itoaxaca.api.v1.syllabus.domain.Syllabus;
import mx.edu.itoaxaca.api.v1.syllabus.domain.SyllabusRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class SyllabusGetAll {

    public static Page<Syllabus> run(Pageable pageable, SyllabusRepository repo) {
        return repo.findAll(pageable);
    }
}
