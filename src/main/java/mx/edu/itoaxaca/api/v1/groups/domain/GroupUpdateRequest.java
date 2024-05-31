package mx.edu.itoaxaca.api.v1.groups.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Setter;

@Setter
public class GroupUpdateRequest {

    @NotNull
    private String code;

    @NotNull
    private String name;

    public Group asGroup() {
        return new Group(
            null,
            new GroupName(this.name),
            new GroupCode(this.code),
           null 
        );
    }
}
