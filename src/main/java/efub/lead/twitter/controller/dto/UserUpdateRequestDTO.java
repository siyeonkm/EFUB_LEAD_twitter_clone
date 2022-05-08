package efub.lead.twitter.controller.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class UserUpdateRequestDTO {
    private String nickname;
    private String twitterId;
    private String bio;
}
