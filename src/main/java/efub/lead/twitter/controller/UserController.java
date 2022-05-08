package efub.lead.twitter.controller;

import efub.lead.twitter.controller.dto.FollowResponseDTO;
import efub.lead.twitter.controller.dto.UserRequestDTO;
import efub.lead.twitter.controller.dto.UserResponseDTO;
import efub.lead.twitter.domain.Follow;
import efub.lead.twitter.domain.User;
import efub.lead.twitter.service.FollowService;
import efub.lead.twitter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
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
        return userService.findUserDTOById(user_id);
    }

    @GetMapping("/{user_id}/followee")
    public List<FollowResponseDTO> findFolloweeById(@PathVariable Long user_id) {
        User me = userService.findUserById(user_id);
        List<User> followees = followService.findFolloweesById(me);
        return userService.findUsersByFolloweeId(followees);
    }

    @GetMapping("/{user_id}/follower")
    public List<FollowResponseDTO> findFollowerById(@PathVariable Long user_id) {
        User me = userService.findUserById(user_id);
        List<User> followers = followService.findFollowersById(me);
        return userService.findUsersByFollowerId(followers);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity nullError() {
        return ResponseEntity.ok("존재하지 않는 유저입니다");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity mismatchError() {
        return ResponseEntity.ok("올바르지 않은 유저 아이디입니다");
    }

}
