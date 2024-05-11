package mx.edu.itoaxaca.api.v1.support_staff.domain;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SupportStaffRepository {
    SupportStaff save(SupportStaff arg);
    Page<SupportStaff> findAll(Pageable pageable);
    void deleteById(UUID id);
    SupportStaff findSupportStaffById(UUID id);
}
