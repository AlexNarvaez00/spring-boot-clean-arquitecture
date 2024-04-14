package mx.edu.itoaxaca.api.v1.career.infrastructura.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.career.domain.Career;
import mx.edu.itoaxaca.api.v1.career.domain.CareerRespository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PostgresCareerRespository extends JpaRepository<Career, UUID>, CareerRespository {}
