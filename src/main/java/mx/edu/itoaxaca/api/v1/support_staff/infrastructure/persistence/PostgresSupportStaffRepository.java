package mx.edu.itoaxaca.api.v1.support_staff.infrastructure.persistence;

import java.util.UUID;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaff;
import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaffRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresSupportStaffRepository 
    extends JpaRepository<SupportStaff, UUID>, SupportStaffRepository {}
