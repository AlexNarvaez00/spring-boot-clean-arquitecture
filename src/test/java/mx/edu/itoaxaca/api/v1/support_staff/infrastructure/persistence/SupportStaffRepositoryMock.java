package mx.edu.itoaxaca.api.v1.support_staff.infrastructure.persistence;

import org.mockito.Mockito;

import mx.edu.itoaxaca.api.v1.support_staff.domain.SupportStaffRepository;

public class SupportStaffRepositoryMock {

    public static SupportStaffRepository mock(){
        return Mockito.mock(SupportStaffRepository.class);
    }
}
