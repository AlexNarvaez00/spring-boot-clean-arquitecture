package mx.edu.itoaxaca.api.v1.type_support_area.domain;

import java.util.UUID;

public record TypeSupportArea (UUID id, TypeSupportAreaType type) {
    public TypeSupportAreaPrimitives toPrimitives() {
        return new TypeSupportAreaPrimitives(id.toString(), type.getValue());
    }
}
