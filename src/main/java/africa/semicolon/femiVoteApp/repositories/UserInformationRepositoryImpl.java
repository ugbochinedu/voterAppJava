package africa.semicolon.femiVoteApp.repositories;

import africa.semicolon.femiVoteApp.models.Admin;
import africa.semicolon.femiVoteApp.models.UserInformation;
import africa.semicolon.femiVoteApp.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class UserInformationRepositoryImpl implements UserInformationRepository{

    private final List<UserInformation> userInformationCollection = new ArrayList<>();
    @Override
    public UserInformation findById(String id) {
        //return userInformationCollection.stream().filter(userInformation -> userInformation.getId().equals(id)).findAny().orElse(null);
        for (UserInformation userInformation : userInformationCollection) {
            if (userInformation.getId().equals(id)) return userInformation;
        }
        return null;
    }

    @Override
    public List<UserInformation> findAll() {
        return userInformationCollection;
    }

    @Override
    public UserInformation save(UserInformation userInformation) {
        userInformation.setId(AppUtils.generateId());
        userInformationCollection.add(userInformation);
        return userInformation;
    }

    @Override
    public void deleteById(String id) {
        UserInformation foundUserInformation = findById(id);
        userInformationCollection.remove(foundUserInformation);
    }
}
