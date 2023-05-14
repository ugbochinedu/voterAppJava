package africa.semicolon.femiVoteApp.services;

import africa.semicolon.femiVoteApp.dtos.request.PartyRegistrationRequest;
import africa.semicolon.femiVoteApp.dtos.response.PartyRegistrationResponse;
import africa.semicolon.femiVoteApp.exception.PartyRegistrationException;
import africa.semicolon.femiVoteApp.exception.VoterRegistrationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class femiAppPartyServiceTest {
    private  final PartyService partyService = new femiAppPartyService();

    @Test
    void partyRegistrationTest(){
        PartyRegistrationRequest partyRegistrationRequest = new PartyRegistrationRequest();
        partyRegistrationRequest.setUsername("ugbo");
        partyRegistrationRequest.setPassword("me12355");

        try {
            PartyRegistrationResponse partyRegistrationResponse = partyService.register(partyRegistrationRequest);
            assertNotNull(partyRegistrationResponse);
        }catch (PartyRegistrationException | VoterRegistrationException exception){
            System.out.println(exception);
        }
    }
}