package africa.semicolon.femiVoteApp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserInformation {
    private String username;
    private String password;
    private String id;
}
