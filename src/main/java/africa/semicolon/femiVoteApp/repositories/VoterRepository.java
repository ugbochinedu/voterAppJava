package africa.semicolon.femiVoteApp.repositories;

import africa.semicolon.femiVoteApp.models.Voter;

import java.util.List;

public interface VoterRepository {
    Voter findById(String id);
    List<Voter> findAll();
    Voter save(Voter voter);
    void deleteById(String id);
}
