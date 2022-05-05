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

    @GetMapping("/registration")
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping("/{user_id}")
    public UserResponseDTO findUserById(@PathVariable Long user_id) {
        return userService.findUserById(user_id);
    }

    @GetMapping("/{user_id}/followee")
    public List<FollowResponseDTO> findFolloweeById(@PathVariable Long user_id) {
        List<Long> followees = followService.findFolloweesById(user_id);
        return userService.findUsersByFolloweeId(followees);
    }

    @GetMapping("/{user_id}/follower")
    public List<FollowResponseDTO> findFollowerById(@PathVariable Long user_id) {
        List<Long> followers = followService.findFollowersById(user_id);
        return userService.findUsersByFollowerId(followers);
    }

}
