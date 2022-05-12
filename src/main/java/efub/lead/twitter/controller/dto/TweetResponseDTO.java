package efub.lead.twitter.controller.dto;

import efub.lead.twitter.domain.Tweet;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TweetResponseDTO {
    private Long tweetId;
    private Long userId;
    private String content;
    private String nickname;
    private String twitterId;
    private LocalDateTime createdDate;

    public TweetResponseDTO(Tweet entity){
        this.tweetId = entity.getTweetId();
        this.userId = entity.getUser().getUserId();
        this.content = entity.getContent();
        this.nickname = entity.getUser().getNickname();
        this.twitterId = entity.getUser().getTwitterId();
        this.createdDate = entity.getCreatedAt();
    }
}
