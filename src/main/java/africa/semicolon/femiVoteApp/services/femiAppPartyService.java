package africa.semicolon.femiVoteApp.services;

import africa.semicolon.femiVoteApp.dtos.request.PartyRegistrationRequest;
import africa.semicolon.femiVoteApp.dtos.response.DeletePartyResponse;
import africa.semicolon.femiVoteApp.dtos.response.PartyRegistrationResponse;
import africa.semicolon.femiVoteApp.exception.PartyRegistrationException;
import africa.semicolon.femiVoteApp.mappers.ModelMapper;
import africa.semicolon.femiVoteApp.models.Party;
import africa.semicolon.femiVoteApp.repositories.PartyRepository;
import africa.semicolon.femiVoteApp.repositories.PartyRepositoryImpl;


import java.util.List;

public class femiAppPartyService implements PartyService{
    private  final PartyRepository partyRepository = new PartyRepositoryImpl();
    @Override
    public PartyRegistrationResponse register(PartyRegistrationRequest partyRegistrationRequest) throws PartyRegistrationException {
        Party party = ModelMapper.map(partyRegistrationRequest);
        Party savedParty  = partyRepository.save(party);
        if (savedParty == null) throw new PartyRegistrationException("Party registration failed");
        PartyRegistrationResponse partyRegistrationResponse = new PartyRegistrationResponse();
        partyRegistrationResponse.setMessage("Registration Successful");
        return partyRegistrationResponse;
    }

    @Override
    public Party findPartyById(String id) {
        return partyRepository.findById(id);
    }

    @Override
    public List<Party> findAllParties() {
        return partyRepository.findAll();
    }

    @Override
    public Party findByName(String name) {
        return partyRepository.findByName(name);
    }

    @Override
    public DeletePartyResponse deleteById(String id) {
      partyRepository.deleteById(id);
      return DeletePartyResponse.builder().message("Party deleted").build();
    }
}
