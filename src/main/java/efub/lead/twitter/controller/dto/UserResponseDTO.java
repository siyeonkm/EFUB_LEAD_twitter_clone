package efub.lead.twitter.controller.dto;

import efub.lead.twitter.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//DTO는 아무 인수가 없는 생성자라도 있어야해서 noArgs를 많이 씀
public class UserResponseDTO {
    private String nickname;
    private String twitterId;
    private String bio;
    private LocalDateTime createdDate;

    public UserResponseDTO(User entity) {
        this.nickname = entity.getNickname();
        this.twitterId = entity.getTwitterId();
        this.bio = entity.getBio();
        this.createdDate = entity.getCreatedAt();
    }

}
