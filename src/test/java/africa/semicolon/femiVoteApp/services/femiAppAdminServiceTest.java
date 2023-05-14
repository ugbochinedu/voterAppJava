package africa.semicolon.femiVoteApp.services;

import africa.semicolon.femiVoteApp.dtos.request.AdminRegistrationRequest;
import africa.semicolon.femiVoteApp.dtos.response.AdminRegistrationResponse;;
import africa.semicolon.femiVoteApp.exception.AdminRegistrationException;
import africa.semicolon.femiVoteApp.exception.PartyRegistrationException;
import africa.semicolon.femiVoteApp.exception.VoterRegistrationException;
import africa.semicolon.femiVoteApp.repositories.AdminRepository;
import africa.semicolon.femiVoteApp.repositories.AdminRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class femiAppAdminServiceTest {
    private final AdminService adminService = new femiAppAdminService();

    @Test
    void partyRegistrationTest(){
        AdminRegistrationRequest adminRegistrationRequest = new AdminRegistrationRequest();
        adminRegistrationRequest.setUsername("ugbo");
        adminRegistrationRequest.setPassword("me12355");

        try {
            AdminRegistrationResponse adminRegistrationResponse = adminService.register(adminRegistrationRequest);
            assertNotNull(adminRegistrationResponse);
        } catch (AdminRegistrationException e) {
            System.out.println(e);
        }
    }
}