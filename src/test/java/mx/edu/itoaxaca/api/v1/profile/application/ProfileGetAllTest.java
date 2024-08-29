package mx.edu.itoaxaca.api.v1.profile.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import mx.edu.itoaxaca.api.v1.profile.domain.Profile;
import mx.edu.itoaxaca.api.v1.profile.infrastructure.persistence.ProfileRepositoryMock;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Criteria;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Field;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Filter;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Filters;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Limit;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Offset;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Operator;
import mx.edu.itoaxaca.api.v1.shared.domain.criteria.Value;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class ProfileGetAllTest {

    @Test
    void testRun() {
        var creator = new ProfileGetAll();

        var repo = ProfileRepositoryMock.mock();

        PageRequest pageReq = PageRequest.of(0, 2);
        Page<Profile> profiles = new PageImpl<Profile>(
            new ArrayList<Profile>(),
            pageReq,
            0
        );

        Filter filter = new Filter(
            new Field("name"),
            Operator.INCLUDE,
            new Value("")
        );
        Filters filters = new Filters(new Filter[] { filter });
        Limit limited = new Limit(10);

        Mockito.when(repo.findAll(pageReq)).thenReturn(profiles);
        Page<Profile> all = ProfileGetAll.run(
            repo,
            new Criteria(filters, new Offset(1), limited)
        );
        assertEquals(all.getSize(), 2);
    }
}
