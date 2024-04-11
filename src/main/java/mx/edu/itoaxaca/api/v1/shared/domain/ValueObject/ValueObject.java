package mx.edu.itoaxaca.api.v1.shared.domain.ValueObject;

public interface ValueObject<TypeValue> {
    public boolean isValid(TypeValue value);

    public TypeValue getValue();
}
