package mx.edu.itoaxaca.api.v1.support_area.infrastructure.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edu.itoaxaca.api.v1.support_area.domain.SupportArea;
import mx.edu.itoaxaca.api.v1.support_area.domain.SupportAreaRepository;

public interface PostgresSupportAreaRepository
    extends JpaRepository<SupportArea, UUID>, SupportAreaRepository {}
