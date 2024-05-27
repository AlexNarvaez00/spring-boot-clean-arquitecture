package mx.edu.itoaxaca.api.v1.syllabus.infrastructure.controllers;

import java.util.HashMap;
import mx.edu.itoaxaca.Routes;
import mx.edu.itoaxaca.api.v1.syllabus.domain.SyllabusMother;
import mx.edu.itoaxaca.api.v1.syllabus.domain.SyllabusRepository;
import mx.edu.itoaxaca.api.v1.shared.infrastructure.RestClientTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(SyllabusController.class)
public class SyllabusControllerTest extends RestClientTest<SyllabusRepository>{
    @Test
    void testDestroy() throws Exception {
        var syllabus = SyllabusMother.random();
        Mockito.when(this.getRepo().findSyllabusById(syllabus.getId())).thenReturn(
            syllabus
        );
        var url = Routes.API_V1_SYLLABUS_BASE + "/" + syllabus.getId().toString();
        this.delete(url).andExpect(
                MockMvcResultMatchers.status().isNoContent()
            );
    }

    @Test
    void testIndex() throws Exception {
        this.get(Routes.API_V1_SYLLABUS_BASE).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testShow() throws Exception {
        var syllabus = SyllabusMother.random();
        Mockito.when(this.getRepo().findSyllabusById(syllabus.getId())).thenReturn(
            syllabus
        );

        var url = Routes.API_V1_SYLLABUS_BASE + "/" + syllabus.getId().toString();

        this.get(url).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testStore() throws Exception {
        var syllabus = SyllabusMother.random();
        var request = new HashMap<String, Object>();
        request.put("code", syllabus.getCode().getValue());
        request.put("start_date", syllabus.getStartDate().getValue());
        request.put("end_date", syllabus.getEndDate().getValue());
        request.put("career_id", syllabus.getCareer().getId());
        request.put("speciality_id", syllabus.getSpeciality().getId());
        
        this.post(Routes.API_V1_SYLLABUS_BASE, request).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
    }

    @Test
    void testUpdate() throws Exception {
        var syllabus = SyllabusMother.random();
        var syllabusUpdate = SyllabusMother.random();

        var request = new HashMap<String, Object>();
        request.put("code", syllabusUpdate.getCode().getValue());
        request.put("start_date", syllabusUpdate.getStartDate().getValue());
        request.put("end_date", syllabusUpdate.getEndDate().getValue());
        request.put("career_id", syllabusUpdate.getCareer().getId());
        request.put("speciality_id", syllabusUpdate.getSpeciality().getId());

        Mockito.when(this.getRepo().findSyllabusById(syllabus.getId())).thenReturn(
            syllabusUpdate
        );

        var url = Routes.API_V1_SYLLABUS_BASE + "/" + syllabus.getId().toString();
        this.put(url, request).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
