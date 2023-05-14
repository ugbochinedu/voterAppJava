package africa.semicolon.femiVoteApp.services;

import africa.semicolon.femiVoteApp.dtos.request.CreateElectionRequest;
import africa.semicolon.femiVoteApp.dtos.response.CreateElectionResponse;
import africa.semicolon.femiVoteApp.dtos.response.DeleteVoterResponse;
import africa.semicolon.femiVoteApp.models.Election;
import africa.semicolon.femiVoteApp.repositories.ElectionRepository;
import africa.semicolon.femiVoteApp.repositories.ElectionRepositoryImpl;

import java.util.List;

public class femiAppElectionService implements ElectionService{

    private final ElectionRepository electionRepository = new ElectionRepositoryImpl();

    @Override
    public CreateElectionResponse create(CreateElectionRequest createElectionRequest) {
        return null;
    }

    @Override
    public Election getUserById(String id) {
        return null;
    }

    @Override
    public List<Election> getAllElections() {
        return electionRepository.findAll();
    }

    @Override
    public DeleteVoterResponse deleteById(String id) {
        return null;
    }
}
