package africa.semicolon.femiVoteApp.mappers;

import africa.semicolon.femiVoteApp.dtos.request.AdminRegistrationRequest;
import africa.semicolon.femiVoteApp.dtos.request.CreateElectionRequest;
import africa.semicolon.femiVoteApp.dtos.request.PartyRegistrationRequest;
import africa.semicolon.femiVoteApp.dtos.request.VoterRegistrationRequest;
import africa.semicolon.femiVoteApp.models.*;
import java.util.List;

public class ModelMapper {

    public static Voter map(VoterRegistrationRequest voterRegistrationRequest){
        Address address = buildVoterAddress(voterRegistrationRequest);
        UserInformation userInformation = buildVoterOnlineUserInformation(voterRegistrationRequest);
        Voter voter = buildVoter(voterRegistrationRequest,address,userInformation);
        return voter;
    }

    public static Election map(CreateElectionRequest createElectionRequest){
//        Election election = new Election();
//        Category electionCategory = Category.valueOf(createElectionRequest.getElectionCategory().toUpperCase());
//        election.setCategory(electionCategory);
//        LocalDate electionDate = LocalDate.parse(createElectionRequest.getElectionDate());
//        election.setElectionDate(electionDate);
//        List<Party> parties = getPoliticalParties(createElectionRequest.getParties());
//        election.setParties(parties);
        return null;
    }

    private static List<Party> getPoliticalParties(List<String> parties) {
        return null;
    }
    private static Voter buildVoter(VoterRegistrationRequest voterRegistrationRequest, Address address, UserInformation userInformation) {
//        Voter voter = new Voter();
//        voter.setName(voterRegistrationRequest.getName());
//        voter.setAge(voterRegistrationRequest.getAge());
//        voter.setGender(Gender.valueOf(voterRegistrationRequest.getGender().toUpperCase()));
//        voter.setAddress(address);
//        voter.setUserInformation(userInformation);
//        return voter;

        Gender voterGender = Gender.valueOf(voterRegistrationRequest.getGender().toUpperCase());
        return Voter.builder()
                .address(address)
                .gender(voterGender)
                .userInformation(userInformation)
                .name(voterRegistrationRequest.getName())
                .age(voterRegistrationRequest.getAge())
                .build();
    }

    private static UserInformation buildVoterOnlineUserInformation(VoterRegistrationRequest voterRegistrationRequest) {
        UserInformation userInformation = new UserInformation();
        userInformation.setUsername(voterRegistrationRequest.getUsername());
        userInformation.setPassword(voterRegistrationRequest.getPassword());
        return userInformation;
    }

    private static Address buildVoterAddress(VoterRegistrationRequest voterRegistrationRequest) {
        Address address = new Address();
        address.setTown(voterRegistrationRequest.getTown());
        address.setState(voterRegistrationRequest.getState());
        address.setStreet(voterRegistrationRequest.getStreet());
        address.setHouseNumber(voterRegistrationRequest.getHouseNumber());
        address.setLocalGovernmentArea(voterRegistrationRequest.getLga());
        return address;
    }

    public static Party map(PartyRegistrationRequest partyRegistrationRequest) {
        Party party = new Party();
        party.setName(partyRegistrationRequest.getName());
        UserInformation userInformation = new UserInformation();
        userInformation.setUsername(partyRegistrationRequest.getUsername());
        userInformation.setUsername(partyRegistrationRequest.getUsername());
        party.setUserInformation(userInformation);
        return party;
    }

    public static Admin map(AdminRegistrationRequest adminRegistrationRequest) {
        Admin admin = new Admin();
        UserInformation userInformation = new UserInformation();
        userInformation.setUsername(adminRegistrationRequest.getUsername());
        userInformation.setPassword(adminRegistrationRequest.getPassword());
        admin.setUserInformation(userInformation);
        return admin;
    }
}
