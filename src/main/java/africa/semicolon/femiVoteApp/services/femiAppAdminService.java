package africa.semicolon.femiVoteApp.services;

import africa.semicolon.femiVoteApp.dtos.request.AdminRegistrationRequest;
import africa.semicolon.femiVoteApp.dtos.response.AdminRegistrationResponse;
import africa.semicolon.femiVoteApp.dtos.response.DeleteAdminResponse;
import africa.semicolon.femiVoteApp.exception.AdminRegistrationException;
import africa.semicolon.femiVoteApp.mappers.ModelMapper;
import africa.semicolon.femiVoteApp.models.Admin;
import africa.semicolon.femiVoteApp.repositories.AdminRepository;
import africa.semicolon.femiVoteApp.repositories.AdminRepositoryImpl;

import java.util.List;

public class femiAppAdminService implements AdminService{
    private final AdminRepository adminRepository = new AdminRepositoryImpl();
    @Override
    public AdminRegistrationResponse register(AdminRegistrationRequest adminRegistrationRequest) throws AdminRegistrationException {
        Admin admin = ModelMapper.map(adminRegistrationRequest);
        Admin savedAdmin = adminRepository.save(admin);
        if (savedAdmin == null) throw new AdminRegistrationException("Admin registration unsuccessful");
        AdminRegistrationResponse adminRegistrationResponse = new AdminRegistrationResponse();
        adminRegistrationResponse.setMessage("Registration Successful");
        return adminRegistrationResponse;
    }

    @Override
    public Admin findById(String id) {
        return adminRepository.findById(id);
    }

    @Override
    public List<Admin> findAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public DeleteAdminResponse deleteById(String id) {
        adminRepository.deleteById(id);
        return DeleteAdminResponse.builder().message("Admin deleted").build();
    }
}
