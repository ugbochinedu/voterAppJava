package africa.semicolon.femiVoteApp.repositories;

import africa.semicolon.femiVoteApp.models.Party;

import java.util.List;

public interface PartyRepository {
    Party findById(String id);
    List<Party> findAll();
    Party save(Party party);
    void deleteById(String id);
    Party findByName(String name);
}
