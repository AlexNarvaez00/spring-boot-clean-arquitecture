package mx.edu.itoaxaca.api.v1.type_support_area.infrastructure.persistence;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportArea;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaRepository;
import mx.edu.itoaxaca.api.v1.type_support_area.domain.TypeSupportAreaType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostgresTypeSupportAreaRepository
    implements TypeSupportAreaRepository {

    private final PostgresJPATypeSupportAreaRepository repository;

    @Override
    public TypeSupportArea save(TypeSupportArea arg) {
        PostgresTypeSupportArea value = new PostgresTypeSupportArea(
            arg.id(),
            arg.type().getValue()
        );
        var result = this.repository.save(value);

        return new TypeSupportArea(
            result.getId(),
            new TypeSupportAreaType(result.getType())
        );
    }

    @Override
    public Page<TypeSupportArea> findAll(Pageable pageable) {
        return this.repository.findAll(pageable).map(result -> {
                return new TypeSupportArea(
                    result.getId(),
                    new TypeSupportAreaType(result.getType())
                );
            });
    }

    @Override
    public void deleteById(UUID id) {
        this.repository.deleteById(id);
    }

    @Override
    public TypeSupportArea findTypeSupportAreaById(UUID id) {
        var result = this.repository.findById(id).get();
        return new TypeSupportArea(
            result.getId(),
            new TypeSupportAreaType(result.getType())
        );
    }
}
