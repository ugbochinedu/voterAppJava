package africa.semicolon.femiVoteApp.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Election {
    private String id;
    private Category category;
    private LocalDate electionDate;
    private List<Party> parties;
}
