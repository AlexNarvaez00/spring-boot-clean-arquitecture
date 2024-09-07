package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence.PostgresTypeSupportArea;

public class TypeSupportAreaStoreRequestTest {

    @Test
    void testAsTypeSupportArea() {
        TypeSupportArea typeSupportArea = TypeSupportAreaMother.random();
        
        var request = new TypeSupportAreaStoreRequest();
        request.setType(typeSupportArea.type().getValue());

        var typeSupportAreaFromReq = request.asTypeSupportArea();

        assertEquals(
            typeSupportAreaFromReq.type().toString(),
            typeSupportArea.type().toString()
        );
    } 
}
