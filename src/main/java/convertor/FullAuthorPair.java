package convertor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FullAuthorPair {
    private long pmId;
    private long id0;
    private long id1;

    private String surname0;
    private String givename0;
    private String initials0;
    private String fullnames0;

    private String surname1;
    private String givename1;
    private String initials1;
    private String fullnames1;
    private String pub_date_str;

    public FullAuthorPair(long id0, long id1, String fullnames0, String fullnames1, String pub_date_str) {
        this.id0 = id0;
        this.id1 = id1;
        this.fullnames0 = fullnames0;
        this.fullnames1 = fullnames1;
        this.pub_date_str = pub_date_str;
    }

    public FullAuthorPair(long id0, long id1, String fullnames0, String fullnames1) {
        this.id0 = id0;
        this.id1 = id1;
        this.fullnames0 = fullnames0;
        this.fullnames1 = fullnames1;
    }
}
