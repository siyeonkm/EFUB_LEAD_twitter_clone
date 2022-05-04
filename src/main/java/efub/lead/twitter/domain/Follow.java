package efub.lead.twitter.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followId;

    @ManyToOne
    @JoinColumn(name="follower_id")
    private User follower;

    @ManyToOne
    @JoinColumn(name="followee_id")
    private User followee;

    @Builder
    public Follow(User follower, User followee){
        this.follower = follower;
        this.followee = followee;
    }


}
