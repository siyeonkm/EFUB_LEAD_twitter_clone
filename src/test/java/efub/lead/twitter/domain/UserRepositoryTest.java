package efub.lead.twitter.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class UserRepositoryTest {
    @Autowired UserRepository userRepository;

    @Test
    @DisplayName("Auditing 기능 적용")
    void findUser() {
        User user = User.builder()
                .nickname("test1")
                .twitter_id("test111")
                .build();

        User savedUser = userRepository.save(user);

        assertNotNull(savedUser.getCreated_at());
    }
}