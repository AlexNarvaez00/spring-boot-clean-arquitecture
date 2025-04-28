package mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportArea;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaRepository;

@Service
@Transactional("type-support-area")
public class PostgresTypeSupportAreaRepository
    implements TypeSupportAreaRepository {

    @Override
    public void save(TypeSupportArea arg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<TypeSupportArea> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
