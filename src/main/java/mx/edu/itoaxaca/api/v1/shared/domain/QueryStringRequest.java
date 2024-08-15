package mx.edu.itoaxaca.api.v1.shared.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Criteria;

@Getter
@Setter
public abstract class QueryStringRequest {

    @Min(value = -1)
    private int page = 0;

    @NotNull
    private String orderBy = "";

    @Min(1)
    @Max(200)
    private int size = 1;

    public abstract Criteria asCriteria();
}
