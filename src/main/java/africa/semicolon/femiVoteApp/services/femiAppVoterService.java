package africa.semicolon.femiVoteApp.services;

import africa.semicolon.femiVoteApp.dtos.request.VoterRegistrationRequest;
import africa.semicolon.femiVoteApp.dtos.response.DeleteVoterResponse;
import africa.semicolon.femiVoteApp.dtos.response.VoterRegistrationResponse;
import africa.semicolon.femiVoteApp.exception.VoterRegistrationException;
import africa.semicolon.femiVoteApp.mappers.ModelMapper;
import africa.semicolon.femiVoteApp.models.Voter;
import africa.semicolon.femiVoteApp.repositories.VoterRepository;
import africa.semicolon.femiVoteApp.repositories.VoterRepositoryImpl;

import java.util.List;
import java.util.UUID;
import static africa.semicolon.femiVoteApp.utils.AppUtils.*;

public class femiAppVoterService implements VoterService{
    private final VoterRepository voterRepository = new VoterRepositoryImpl();


    @Override
    public VoterRegistrationResponse register(VoterRegistrationRequest voterRegistrationRequest) throws VoterRegistrationException {
        Voter voter = ModelMapper.map(voterRegistrationRequest);
        String vin = generateVoterIdentificationNumber();
        voter.setVoterIdentificationNumber(vin);
        Voter savedVoter = voterRepository.save(voter);
        if (savedVoter==null) throw new VoterRegistrationException("Voter registration failed");
        VoterRegistrationResponse voterRegistrationResponse = new VoterRegistrationResponse();
        voterRegistrationResponse.setMessage("Registration Successful. May your vote count");
        voterRegistrationResponse.setVotersIdentificationNumber(savedVoter.getVoterIdentificationNumber());
        return voterRegistrationResponse;
    }

    @Override
    public Voter getUserById(String id) {
        return voterRepository.findById(id);
    }

    @Override
    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    @Override
    public DeleteVoterResponse deleteById(String id) {
        voterRepository.deleteById(id);
        return DeleteVoterResponse.builder().message("Voter deleted").build();
    }


    private static String generateVoterIdentificationNumber(){
        String uuid = generateUUID();
        String validUUID = stripInvalidCharactersFrom(uuid);
        return buildVoterIdentificationNumberFrom(validUUID);
    }

    private static String buildVoterIdentificationNumberFrom(String validUuid) {
        String result="";
        for (int index = ZERO; index < validUuid.length() ; index++) {
            if (index%FIVE==ZERO) result+=" ";
            else result+= validUuid.charAt(index);
        }
        int endIndex = result.length() - EIGHT;
        return result.substring(ZERO, endIndex).strip();
    }


    private static String stripInvalidCharactersFrom(String randomUUID) {
        String validuuid="";
        for (int index = ZERO; index < randomUUID.length() ; index++) {
            char currentCharacter = randomUUID.charAt(index);
            if (currentCharacter!='-')validuuid += randomUUID.charAt(index);
        }
        return validuuid;
    }


    private static String generateUUID() {
        UUID randomUuid = UUID.randomUUID();
        String uuid = randomUuid.toString();
        return uuid.toUpperCase();
    }
}