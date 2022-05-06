package efub.lead.twitter.controller;

import efub.lead.twitter.controller.dto.TweetRequestDTO;
import efub.lead.twitter.controller.dto.TweetResponseDTO;
import efub.lead.twitter.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/tweets/{twitter_id}")
    public List<TweetResponseDTO> getTweetsByTwitterId(@PathVariable String twitter_id){
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
    public String deleteTweet(@PathVariable Long tweet_id){
        tweetService.deleteTweet(tweet_id);
        return "deleted";
    }

}
