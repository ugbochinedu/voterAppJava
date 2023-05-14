package africa.semicolon.femiVoteApp.services;

import africa.semicolon.femiVoteApp.dtos.request.VoterRegistrationRequest;
import africa.semicolon.femiVoteApp.dtos.response.DeleteVoterResponse;
import africa.semicolon.femiVoteApp.dtos.response.VoterRegistrationResponse;
import africa.semicolon.femiVoteApp.exception.VoterRegistrationException;
import africa.semicolon.femiVoteApp.models.Voter;

import java.util.List;

public interface VoterService {
    VoterRegistrationResponse register(VoterRegistrationRequest voterRegistrationRequest) throws VoterRegistrationException;
    Voter getUserById(String id);
    List<Voter> getAllVoters();
    DeleteVoterResponse deleteById(String id);
}
