package efub.lead.twitter.service;

import efub.lead.twitter.controller.dto.TweetRequestDTO;
import efub.lead.twitter.controller.dto.TweetResponseDTO;
import efub.lead.twitter.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class TweetServiceTest {
    @Autowired private TweetService tweetService;

    @Test
    @DisplayName("트윗 포스팅 테스트")
    void saveTweet() {
        TweetRequestDTO tweet = TweetRequestDTO.builder()
                .userId(1L)
                .content("content01")
                .build();
        TweetResponseDTO tweetResponseDTO = tweetService.saveTweet(tweet);
        assertThat(tweetResponseDTO.getContent()).isEqualTo("content01");
    }

    @Test
    @DisplayName("트윗 조회 테스트")
    void getTweetTest(){
        List<TweetResponseDTO> tweetListByTwitterId = tweetService.getTweetListByTwitterId("@Efub_manager");
        System.out.println("TwitterId = " + tweetListByTwitterId.get(0).getTwitterId());
        assertThat(tweetListByTwitterId.size()).isEqualTo(1);
    }


}