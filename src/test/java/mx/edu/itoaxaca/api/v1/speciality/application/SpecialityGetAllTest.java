package mx.edu.itoaxaca.api.v1.speciality.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import mx.edu.itoaxaca.api.v1.speciality.domain.Speciality;
import mx.edu.itoaxaca.api.v1.speciality.infrastructure.persistence.SpecialityRepositoryMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class SpecialityGetAllTest {
    @Test
    void runTest() {
        var creator = new SpecialityGetAll();

        var repo = SpecialityRepositoryMock.mock();

        PageRequest pageReq = PageRequest.of(0, 2);
        Page<Speciality> specialitys = new PageImpl<Speciality>(new ArrayList<Speciality>(), pageReq, 0);

        Mockito.when(repo.findAll(pageReq)).thenReturn(specialitys);
        Page<Speciality> all = SpecialityGetAll.run(pageReq, repo);
        assertEquals(all.getSize(), 2);
    }
}
