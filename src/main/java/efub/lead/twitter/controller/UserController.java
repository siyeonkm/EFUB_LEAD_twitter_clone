package efub.lead.twitter.controller;

import efub.lead.twitter.controller.dto.FollowResponseDTO;
import efub.lead.twitter.controller.dto.TweetResponseDTO;
import efub.lead.twitter.controller.dto.UserResponseDTO;
import efub.lead.twitter.service.FollowService;
import efub.lead.twitter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final FollowService followService;

    @GetMapping("/{user_id}")
    public UserResponseDTO searchUserById(@PathVariable Long user_id) {
        return new UserResponseDTO();
    }

    @PatchMapping("/{user_id}")
    public UserResponseDTO updateUserById(@PathVariable Long user_id) {
        return new UserResponseDTO();
    }

    @GetMapping("/{user_id}/mytweets")
    public TweetResponseDTO searchTweetsById(@PathVariable Long user_id) {
        return new TweetResponseDTO();
    }

    @GetMapping("/{user_id}/followee")
    public FollowResponseDTO searchFolloweesById(@PathVariable Long user_id) {
        return new FollowResponseDTO();
    }

    @GetMapping("/{user_id}/follower")
    public FollowResponseDTO searchFollowersById(@PathVariable Long user_id) {
        return new FollowResponseDTO();
    }
}
