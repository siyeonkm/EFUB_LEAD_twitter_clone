package efub.lead.twitter.controller;

import efub.lead.twitter.controller.dto.TweetRequestDTO;
import efub.lead.twitter.controller.dto.TweetResponseDTO;
import efub.lead.twitter.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@CrossOrigin
@RequiredArgsConstructor
@RestController
public class TweetController {
    private final TweetService tweetService;

    @GetMapping("/tweets")
    public List<TweetResponseDTO> getTweets(){
        return tweetService.getTweetList();
    }

    @GetMapping("/tweets/{tweet_id}")
    public TweetResponseDTO getTweet(@PathVariable Long tweet_id){
        return tweetService.getTweet(tweet_id);
    }

    @GetMapping("/tweets/twitterId/{twitter_id}")
    public List<TweetResponseDTO> getTweetsByTwitterId( @PathVariable String twitter_id){
        return tweetService.getTweetListByTwitterId(twitter_id);
    }

    @GetMapping("users/{user_id}/mytweets")
    public List<TweetResponseDTO> getTweetsByTwitterId(@PathVariable Long user_id){
        return tweetService.getTweetListByUserId(user_id);
    }

    @PostMapping("/tweets")
    public String postTweet(@RequestBody TweetRequestDTO tweetDTO){
        tweetService.saveTweet(tweetDTO);
        return "uploaded";
    }

    @DeleteMapping("/tweets/{tweet_id}")
    public String deleteTweet(@PathVariable Long tweet_id, @RequestBody Map<String, Long> user){
        Long user_id = user.get("userId");
        tweetService.deleteTweet(tweet_id, user_id);
        return "deleted";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity noSuchElementException(){ //존재하지 않는 트윗의 id로 조회 시
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("존재하지 않는 트윗입니다.");
    }

    @ExceptionHandler(NullPointerException.class) //존재하지 않는 유저의 트위터 id로 조회 시
    public ResponseEntity nullException(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("존재하지 않는 유저입니다.");
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity forbiddenDeleteExeption(){ //본인이 작성하지 않은 트윗 삭제 시도 시
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("forbidden");
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity emptyResultExeption(){ //존재하지 않는 트윗의 id로 삭제 시
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("존재하지 않는 트윗입니다.");
    }

}
