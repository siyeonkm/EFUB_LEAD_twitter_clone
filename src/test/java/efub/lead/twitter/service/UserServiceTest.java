package efub.lead.twitter.service;

import efub.lead.twitter.controller.dto.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    @DisplayName("유저 업데이트 테스트")
    void updateUser() {
        UserUpdateRequestDTO userUpdate = UserUpdateRequestDTO.builder()
                                            .bio("아 소개글에 뭐쓰지").build();
        userService.updateUserById(1L, userUpdate);
        UserResponseDTO userResponseDTO = userService.findUserDTOById(1L);
        assertThat(userResponseDTO.getBio()).isEqualTo("아 소개글에 뭐쓰지");
    }
}
