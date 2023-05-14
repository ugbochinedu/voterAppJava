package africa.semicolon.femiVoteApp.repositories;
import africa.semicolon.femiVoteApp.models.UserInformation;
import java.util.List;

public interface UserInformationRepository {
    UserInformation findById(String id);
    List<UserInformation> findAll();
    UserInformation save(UserInformation userInformation);
    void deleteById(String id);
}
