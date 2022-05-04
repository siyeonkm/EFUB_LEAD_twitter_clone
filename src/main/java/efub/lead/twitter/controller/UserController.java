package efub.lead.twitter.controller;

import efub.lead.twitter.controller.dto.UserRequestDTO;
import efub.lead.twitter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/registration")
    public Long createUser(@RequestBody UserRequestDTO userDTO) {
        return userService.createUser(userDTO);
    }

}
