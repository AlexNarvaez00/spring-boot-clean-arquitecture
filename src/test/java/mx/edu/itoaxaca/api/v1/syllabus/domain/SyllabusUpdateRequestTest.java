package mx.edu.itoaxaca.api.v1.syllabus.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SyllabusUpdateRequestTest {

    @Test
    void testAsSyllabus() {
        Syllabus syllabus = SyllabusMother.random();
        var request = new SyllabusUpdateRequest();
        request.setCode(syllabus.getCode().getValue());
        request.setStart_date(syllabus.getStartDate().getValue());
        request.setEnd_date(syllabus.getEndDate().getValue());

        var syllabusFromReq = request.asSyllabus();

        assertEquals(
            syllabus.getCode().getValue(),
            syllabusFromReq.getCode().getValue()
        );
    }
}
