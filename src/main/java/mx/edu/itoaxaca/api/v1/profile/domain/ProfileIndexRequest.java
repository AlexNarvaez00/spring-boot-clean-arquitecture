package mx.edu.itoaxaca.api.v1.profile.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import mx.edu.itoaxaca.api.v1.shared.domain.QueryStringRequest;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Criteria;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Field;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Filter;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Filters;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Limit;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Offset;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Operator;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Value;

@Getter
@Setter
public class ProfileIndexRequest extends QueryStringRequest {

    @NotNull
    private String name = "";

    @NotNull
    private String email = "";

    @Override
    public Criteria asCriteria() {
        Filter[] filter = {
            new Filter(
                new Field("name"),
                Operator.INCLUDE,
                new Value(this.name)
            ),
            new Filter(
                new Field("email"),
                Operator.INCLUDE,
                new Value(this.email)
            )
        };

        Filters filters = new Filters(filter);
        Limit limit = new Limit(this.getSize());
        Offset offset = new Offset(getPage());

        Criteria criteria = new Criteria(filters, offset, limit);
        return criteria;
    }
}
