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
    public UserResponseDTO findUserById(Long id) {
        User user = userRepository.findUserByUserId(id);
        return buildUserDTO(user);
    }

    @Transactional
    public List<FollowResponseDTO> findUsersByFolloweeId(List<Long> followees) {
        List<FollowResponseDTO> followeeList = new ArrayList<>();
        for(Long id : followees) {
            UserResponseDTO user = findUserById(id);
            followeeList.add(buildFollowDTO(user));
        }
        return followeeList;
    }

    @Transactional
    public List<FollowResponseDTO> findUsersByFollowerId(List<Long> followers) {
        List<FollowResponseDTO> followerList = new ArrayList<>();
        for(Long id : followers) {
            UserResponseDTO user = findUserById(id);
            followerList.add(buildFollowDTO(user));
        }
        return followerList;
    }

    public UserResponseDTO buildUserDTO(User user) {
        return new UserResponseDTO(user);
    }

    public FollowResponseDTO buildFollowDTO(UserResponseDTO user) {
        return new FollowResponseDTO(user);
    }

}
