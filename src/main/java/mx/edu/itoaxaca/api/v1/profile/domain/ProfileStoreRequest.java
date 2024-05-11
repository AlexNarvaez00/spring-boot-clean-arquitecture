package mx.edu.itoaxaca.api.v1.profile.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProfileStoreRequest {
    private UUID id;
    
    @NotNull
    private String name;
    
    @NotNull
    @Email
    private String email; 
    
    @NotNull
    private String password;
    
    public Profile asProfile() {
        return new Profile(
            (this.id == null) ? null : UUID.randomUUID(),
            new ProfileName(this.name),
            new ProfileEmail(this.email),
            new ProfilePassword(this.password),
            new ProfileCreatedAt(LocalDateTime.now()),
            null
        );
    }
}
