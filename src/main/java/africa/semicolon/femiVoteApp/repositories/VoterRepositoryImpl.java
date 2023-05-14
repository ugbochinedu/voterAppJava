package africa.semicolon.femiVoteApp.repositories;

import africa.semicolon.femiVoteApp.models.Voter;
import africa.semicolon.femiVoteApp.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class VoterRepositoryImpl implements VoterRepository{
    private List<Voter> voters = new ArrayList<>();
    @Override
    public Voter findById(String id) {
        for (Voter voter:voters) {
            if (voter.getId().equals(id)) return voter;
        }
        return null;
    }

    @Override
    public List<Voter> findAll() {
        return voters;
    }

    @Override
    public Voter save(Voter voter) {
        String id = AppUtils.generateId();
        voter.setId(id);
        voters.add(voter);
        return voter;
    }

    @Override
    public void deleteById(String id) {
        Voter foundVoter = findById(id);
        if(foundVoter != null)voters.remove(foundVoter);
    }
}
