package mx.edu.itoaxaca.api.v1.syllabus.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SyllabusStoreRequestTest {

    @Test
    void testAsSyllabus() {
        Syllabus syllabus = SyllabusMother.random();
        var request = new SyllabusStoreRequest();
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
