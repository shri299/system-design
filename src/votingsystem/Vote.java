package votingsystem;

import java.util.Date;

public class Vote {
    private String voterId;
    private String candidateId;
    private Date timestamp;

    public Vote(String voterId, String candidateId, Date date) {
        this.candidateId=candidateId;
        this.voterId=voterId;
        this.timestamp=date;
    }
}
