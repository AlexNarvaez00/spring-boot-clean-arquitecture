package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TypeSupportAreaUpdateRequestTest {

    @Test
    void testAsTypeSupportArea() {
        TypeSupportArea typeSupportArea = TypeSupportAreaMother.random();
        var request = new TypeSupportAreaUpdateRequest();
        request.setType(typeSupportArea.getType().getValue());

        var typeSupportAreaFromReq = request.asTypeSupportArea();

        assertEquals(
            typeSupportAreaFromReq.getType().toString(),
            typeSupportArea.getType().toString()
        );
    }
}
