package africa.semicolon.femiVoteApp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Voter {
    private UserInformation userInformation;
    private String voterIdentificationNumber;
    private String name;
    private Address address;
    private Integer age;
    private Gender gender;
    private String id;
}
