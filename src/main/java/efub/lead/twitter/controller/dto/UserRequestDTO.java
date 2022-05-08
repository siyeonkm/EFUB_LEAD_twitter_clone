package efub.lead.twitter.controller.dto;

import efub.lead.twitter.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequestDTO {
    private String nickname;
    private String twitterId;
    private String bio;

    @Builder
    public UserRequestDTO(String nickname, String twitterId, String bio) {
        this.nickname = nickname;
        this.twitterId = twitterId;
        this.bio = bio;
    }
}
