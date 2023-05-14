package africa.semicolon.femiVoteApp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Address {
    private String houseNumber;
    private String street;
    private String town;
    private String state;
    private String localGovernmentArea;
    private String id;
}
