package africa.semicolon.femiVoteApp.services;

import africa.semicolon.femiVoteApp.dtos.request.AdminRegistrationRequest;
import africa.semicolon.femiVoteApp.dtos.response.AdminRegistrationResponse;
import africa.semicolon.femiVoteApp.dtos.response.DeleteAdminResponse;
import africa.semicolon.femiVoteApp.exception.AdminRegistrationException;
import africa.semicolon.femiVoteApp.models.Admin;
import africa.semicolon.femiVoteApp.models.Party;

import java.util.List;

public interface AdminService {
    AdminRegistrationResponse register(AdminRegistrationRequest adminRegistrationRequest) throws AdminRegistrationException;
    Admin findById(String id);
    List<Admin> findAllAdmins();
    DeleteAdminResponse deleteById(String id);
}
