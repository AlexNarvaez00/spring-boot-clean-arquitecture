package mx.edu.itoaxaca.api.v1.support_area.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SupportAreaUpdateRequestTest {
    @Test
    void testAsSupportArea() {
        SupportArea support_area = SupportAreaMother.random();
        var request = new SupportAreaUpdateRequest();
        request.setName(support_area.getName().getValue());
        request.setShort_name(support_area.getShortName().getValue());
        
        var support_areaFromReq = request.asSupportArea();

        assertEquals(
            support_areaFromReq.getName().getValue(),
            support_area.getName().getValue()
        );
        assertEquals(
            support_areaFromReq.getShortName().getValue(),
            support_area.getShortName().getValue()
        );
    }
   
}
