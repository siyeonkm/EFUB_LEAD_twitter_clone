package efub.lead.twitter.service;

import efub.lead.twitter.controller.dto.TweetRequestDTO;
import efub.lead.twitter.controller.dto.TweetResponseDTO;
import efub.lead.twitter.domain.Tweet;
import efub.lead.twitter.domain.TweetRepository;
import efub.lead.twitter.domain.User;
import efub.lead.twitter.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetService {
    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    @Transactional
    public void saveTweet(TweetRequestDTO tweetDTO){ //게시글 저장
        User user = userRepository.getById(tweetDTO.getUserId());
        Tweet tweet = Tweet.builder()
                .user(user)
                .content(tweetDTO.getContent())
                .build();
        tweetRepository.save(tweet);
    }

    @Transactional
    public List<TweetResponseDTO> getTweetList(){ //게시글 전체 조회
        List<Tweet> tweetList = tweetRepository.findAll();
        List<TweetResponseDTO> tweetDTOList = new ArrayList<>();

        for(Tweet tweet : tweetList){
            TweetResponseDTO tweetResponseDTO = buildTweetDTO(tweet);
            tweetDTOList.add(tweetResponseDTO);
        }

        return tweetDTOList;
    }

    @Transactional
    public TweetResponseDTO getTweet(Long tweetId){ //게시글 아이디로 조회
        Tweet tweet = tweetRepository.findById(tweetId).get();
        return new TweetResponseDTO(tweet);
    }

    @Transactional
    public List<TweetResponseDTO> getTweetListByTwitterId(String twitterId){ //특정 유저 게시글 전체 조회
        User user = userRepository.findUserByTwitterId(twitterId);
        List<Tweet> tweetList = user.getTweets();
        List<TweetResponseDTO> tweetDTOList = new ArrayList<>();

        for(Tweet tweet : tweetList){
            TweetResponseDTO tweetResponseDTO = buildTweetDTO(tweet);
            tweetDTOList.add(tweetResponseDTO);
        }

        return tweetDTOList;
    }

    @Transactional
    public List<TweetResponseDTO> getTweetListByUserId(Long userId) { //자기가 작성한 글 조회
        User user = userRepository.findUserByUserId(userId);
        List<Tweet> tweetList = user.getTweets();
        List<TweetResponseDTO> tweetDTOList = new ArrayList<>();

        for(Tweet tweet : tweetList){
            TweetResponseDTO tweetResponseDTO = buildTweetDTO(tweet);
            tweetDTOList.add(tweetResponseDTO);
        }

        return tweetDTOList;
    }

    @Transactional
    public void deleteTweet(Long tweetId){
        tweetRepository.deleteById(tweetId);
    }

    public TweetResponseDTO buildTweetDTO(Tweet tweet) {
        return new TweetResponseDTO(tweet);
    }

}
