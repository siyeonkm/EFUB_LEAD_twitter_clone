package efub.lead.twitter.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TweetRequestDTO {
    private Long userId;
    private String content;

    @Builder
    public TweetRequestDTO(Long userId, String content){
        this.userId = userId;
        this.content = content;
    }
}
