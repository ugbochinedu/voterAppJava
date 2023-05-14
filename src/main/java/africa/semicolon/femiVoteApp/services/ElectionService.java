package africa.semicolon.femiVoteApp.services;

import africa.semicolon.femiVoteApp.dtos.request.CreateElectionRequest;
import africa.semicolon.femiVoteApp.dtos.response.CreateElectionResponse;
import africa.semicolon.femiVoteApp.dtos.response.DeleteVoterResponse;
import africa.semicolon.femiVoteApp.models.Election;
import africa.semicolon.femiVoteApp.models.Voter;

import java.util.List;

public interface ElectionService {
    CreateElectionResponse create(CreateElectionRequest createElectionRequest);
    Election getUserById(String id);
    List<Election> getAllElections();
    DeleteVoterResponse deleteById(String id);
}
