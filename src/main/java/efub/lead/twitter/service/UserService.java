package efub.lead.twitter.service;

import efub.lead.twitter.controller.dto.FollowResponseDTO;
import efub.lead.twitter.controller.dto.UserRequestDTO;
import efub.lead.twitter.controller.dto.UserResponseDTO;
import efub.lead.twitter.domain.User;
import efub.lead.twitter.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDTO createUser(UserRequestDTO userDTO){
        User user = User.builder()
                        .nickname(userDTO.getNickname())
                        .twitterId(userDTO.getTwitterId())
                        .bio(userDTO.getBio())
                        .build();

        userRepository.save(user);
        return buildUserDTO(user);
    }

    @Transactional
    public UserResponseDTO findUserDTOById(Long id) {
        User user = userRepository.findUserByUserId(id);
        return buildUserDTO(user);
    }

    @Transactional
    public User findUserById(Long id) {
        User user = userRepository.findUserByUserId(id);
        return user;
    }

    @Transactional
    public List<FollowResponseDTO> findUsersByFolloweeId(List<User> followees) {
        List<FollowResponseDTO> followeeList = new ArrayList<>();
        for(User followee : followees) {
            followeeList.add(buildFollowDTO(followee));
        }
        return followeeList;
    }

    @Transactional
    public List<FollowResponseDTO> findUsersByFollowerId(List<User> followers) {
        List<FollowResponseDTO> followerList = new ArrayList<>();
        for(User follower : followers) {
            followerList.add(buildFollowDTO(follower));
        }
        return followerList;
    }

    public UserResponseDTO buildUserDTO(User user) {
        return new UserResponseDTO(user);
    }

    public FollowResponseDTO buildFollowDTO(User user) {
        return new FollowResponseDTO(user);
    }

}
