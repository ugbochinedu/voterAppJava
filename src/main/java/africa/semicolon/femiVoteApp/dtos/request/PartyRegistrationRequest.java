package africa.semicolon.femiVoteApp.dtos.request;

import lombok.Data;

@Data
public class PartyRegistrationRequest {
    private String username;
    private String password;
    private String name;
}
