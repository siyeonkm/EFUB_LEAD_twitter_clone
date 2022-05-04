package efub.lead.twitter.controller;

import efub.lead.twitter.controller.dto.FollowResponseDTO;
import efub.lead.twitter.controller.dto.UserRequestDTO;
import efub.lead.twitter.controller.dto.UserResponseDTO;
import efub.lead.twitter.service.FollowService;
import efub.lead.twitter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final FollowService followService;
    private final TweetService tweetService;

    @GetMapping("/registration")
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping("/{user_id}")
    public UserResponseDTO findUserById(@RequestParam Long user_id) {
        return userService.findUserById(user_id);
    }

    @PatchMapping("/{user_id}")
    public String updateUserById(@RequestParam Long user_id) {
        return "modified";
    }

    @PatchMapping("/{user_id}/mytweets")
    public List<TweetResponseDTO> findTweetsById(@RequestParam Long user_id) {
        return tweetService.findTweetsById(user_id);
    }

    @GetMapping("/{user_id}/followee")
    public List<FollowResponseDTO> findFolloweeById(@RequestParam Long user_id) {
        List<Long> followees = followService.findFolloweesById(user_id);
        return userService.findUsersByFolloweeId(followees);
    }

    @GetMapping("/{user_id}/follower")
    public List<FollowResponseDTO> findFollowerById(@RequestParam Long user_id) {
        List<Long> followers = followService.findFollowersById(user_id);
        return userService.findUsersByFollowerId(followers);
    }

}
