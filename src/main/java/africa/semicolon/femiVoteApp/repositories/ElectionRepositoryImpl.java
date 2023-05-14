package africa.semicolon.femiVoteApp.repositories;

import africa.semicolon.femiVoteApp.models.Admin;
import africa.semicolon.femiVoteApp.models.Election;
import africa.semicolon.femiVoteApp.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class ElectionRepositoryImpl implements ElectionRepository{

    private final List<Election> elections = new ArrayList<>();
    @Override
    public Election findById(String id) {
        //return elections.stream().filter(election -> election.getId().equals(id)).findAny().orElse(null);
        for (Election election:elections) {
            if (election.getId().equals(id)) return election;
        }
        return null;
    }

    @Override
    public List<Election> findAll() {
        return elections;
    }

    @Override
    public Election save(Election election) {
        election.setId(AppUtils.generateId());
        elections.add(election);
        return election;
    }

    @Override
    public void deleteById(String id) {
        Election foundElection = findById(id);
        if(foundElection != null) elections.remove(foundElection);
    }
}
