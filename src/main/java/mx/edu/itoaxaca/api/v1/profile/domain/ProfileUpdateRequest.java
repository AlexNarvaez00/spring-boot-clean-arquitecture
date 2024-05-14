package mx.edu.itoaxaca.api.v1.profile.domain;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProfileUpdateRequest {
    
     @NotNull
    private String name;
    
    @NotNull
    @Email
    private String email; 
    
    @NotNull
    private String password;

    public Profile asProfile() {
       return new Profile(
             null ,
            new ProfileName(this.name),
            new ProfileEmail(this.email),
            new ProfilePassword(this.password),
            null
        );
    }
}
