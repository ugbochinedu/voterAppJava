package africa.semicolon.femiVoteApp.services;

import africa.semicolon.femiVoteApp.dtos.request.PartyRegistrationRequest;
import africa.semicolon.femiVoteApp.dtos.response.DeletePartyResponse;
import africa.semicolon.femiVoteApp.dtos.response.PartyRegistrationResponse;
import africa.semicolon.femiVoteApp.exception.PartyRegistrationException;
import africa.semicolon.femiVoteApp.exception.VoterRegistrationException;
import africa.semicolon.femiVoteApp.models.Party;

import java.util.List;

public interface PartyService {
    PartyRegistrationResponse register(PartyRegistrationRequest partyRegistrationRequest) throws VoterRegistrationException, PartyRegistrationException;
    Party findPartyById(String id);
    List<Party> findAllParties();
    Party findByName(String name);
    DeletePartyResponse deleteById(String id);
}
