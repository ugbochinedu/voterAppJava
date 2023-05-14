package africa.semicolon.femiVoteApp.repositories;
import africa.semicolon.femiVoteApp.models.Address;
import africa.semicolon.femiVoteApp.models.Party;
import africa.semicolon.femiVoteApp.models.UserInformation;
import africa.semicolon.femiVoteApp.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PartyRepositoryImpl implements PartyRepository{

    private final List<Party> parties = new ArrayList<>();
    private final UserInformationRepository userInformationRepository = new UserInformationRepositoryImpl();

    @Override
    public Party findById(String id) {
        Party foundParty = null;
        for (Party party: parties){
            if(party.getId().equals(id)) foundParty = party;
        }
        if(foundParty != null){
            String userInformationId = AppUtils.getUserInformationId(foundParty.getId());
            UserInformation userInformation = userInformationRepository.findById(userInformationId);
            foundParty.setUserInformation(userInformation);
        }
        return foundParty;
    }

    @Override
    public List<Party> findAll() {
        List<Party> foundParties = new ArrayList<>();
        for (Party party:parties) {
            String userInformationId = AppUtils.getUserInformationId(party.getId());
            if (userInformationId != null){
                var foundUserInformation = userInformationRepository.findById(userInformationId);
                party.setUserInformation(foundUserInformation);
            }
            foundParties.add(party);
        }
        return foundParties;
    }

    @Override
    public Party save(Party party) {
        String id = AppUtils.generateId();
        party.setId(id);
        boolean isPartyWithUserInformation = party.getUserInformation() != null;
        if(isPartyWithUserInformation) saveUserInformation(party);
        parties.add(party);
        return party;
    }

    private void saveUserInformation(Party party) {
        UserInformation savedUserInformation = userInformationRepository.save(party.getUserInformation());
        String partyId = party.getId();
        String userInformationId = savedUserInformation.getId();
        AppUtils.linkUserToUserInformation(partyId, userInformationId);
    }

    @Override
    public void deleteById(String id) {
        Party party = findById(id);
        if(party != null) parties.remove(party);
    }

    @Override
    public Party findByName(String name) {
        return parties.stream().filter(party -> Objects.equals(party.getName(), name)).findAny().orElse(null);
//        for (Party party:parties) {
//          if (Objects.equals(party.getName(), name))return party;
//        }
//        return null;
    }
}
