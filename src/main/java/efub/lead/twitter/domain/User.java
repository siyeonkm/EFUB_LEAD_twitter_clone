package efub.lead.twitter.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(length = 100, nullable = false)
    private String nickname;

    @Column(length = 100, nullable = false, unique = true)
    private String twitter_id;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column(columnDefinition = "TEXT")
    private String image;

    @OneToMany(mappedBy = "user")
    private List<Tweet> tweets = new ArrayList<>();

    @Builder
    public User(String nickname, String twitter_id, String bio, String image){
        this.nickname = nickname;
        this.twitter_id = twitter_id;
        this.bio = bio;
        this.image = image;
    }

}
