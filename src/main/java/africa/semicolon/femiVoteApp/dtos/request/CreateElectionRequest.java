package africa.semicolon.femiVoteApp.dtos.request;

import lombok.Data;

import java.util.List;

@Data
public class CreateElectionRequest {
    private String electionDate;
    private String electionCategory;
    private List<String> states;
    private List<String> parties;
    private List<String> localGovernmentAreas;
}
