package mx.edu.itoaxaca.api.v1.groups.domain;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Setter;

@Setter
public class GroupStoreRequest {

    private UUID id;

    @NotNull
    private String code;

    @NotNull
    private String name;

    public Group asGroup() {
        return new Group(
            (this.id == null) ? null : UUID.randomUUID(),
            new GroupName(this.name),
            new GroupCode(this.code)
        );
    }
}
