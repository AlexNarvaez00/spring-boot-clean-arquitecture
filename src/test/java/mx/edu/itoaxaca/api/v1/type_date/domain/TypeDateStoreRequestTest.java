package mx.edu.itoaxaca.api.v1.type_date.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TypeDateStoreRequestTest {

    @Test
    void testAsTypeDate() {
        TypeDate type_date = TypeDateMother.random();
        var request = new TypeDateStoreRequest();
        request.setName(type_date.getName().getValue());

        var type_dateFromReq = request.asTypeDate();

        assertEquals(
            type_date.getName().getValue(),
            type_dateFromReq.getName().getValue()
        );
    }
}
