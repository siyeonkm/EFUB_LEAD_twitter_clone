package efub.lead.twitter.service;

import efub.lead.twitter.controller.dto.UserRequestDTO;
import efub.lead.twitter.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long createUser(UserRequestDTO userDTO) {
        
    }

}
