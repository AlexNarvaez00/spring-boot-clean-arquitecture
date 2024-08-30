package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.PostgresTypeSupportArea;

public class TypeSupportAreaUpdateRequestTest {

    @Test
    void testAsTypeSupportArea() {
        PostgresTypeSupportArea typeSupportArea = TypeSupportAreaMother.random();
        var request = new TypeSupportAreaUpdateRequest();
        request.setType(typeSupportArea.getType().getValue());

        var typeSupportAreaFromReq = request.asTypeSupportArea();

        assertEquals(
            typeSupportAreaFromReq.getType().toString(),
            typeSupportArea.getType().toString()
        );
    }
}
