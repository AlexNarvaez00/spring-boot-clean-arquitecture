package mx.edu.itoaxaca.api.v1.shared.domain.ValueObject;

import lombok.Getter;

public abstract class PasswordValueObject implements ValueObject<String> {

    @Getter
    private String value;

    public PasswordValueObject(String value) {
        this.value = value;
    }

    @Override
    public boolean isValid(String value) {
        return true;
    }

    public String encrypt(){
        throw new UnsupportedOperationException("Unimplemented method 'isValid'");
    }
    
    public String decrypt(){
        throw new UnsupportedOperationException("Unimplemented method 'isValid'");
    }
}
