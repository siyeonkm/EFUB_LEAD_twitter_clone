package efub.lead.twitter.controller.dto;

import efub.lead.twitter.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FollowResponseDTO {
    private String nickname;
    private String twitterId;

    public FollowResponseDTO(UserResponseDTO entity) {
        this.nickname = entity.getNickname();
        this.twitterId = entity.getTwitterId();
    }

}
