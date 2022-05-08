package efub.lead.twitter.service;

import efub.lead.twitter.domain.Follow;
import efub.lead.twitter.domain.FollowRepository;
import efub.lead.twitter.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;

    public List<User> findFolloweesById(User me) {
        //팔로위는 팔로우를 당하는 사람
        List<Follow> follows = followRepository.findAllByFollower(me);
        List<User> followees = new ArrayList<>();
        for(Follow follow : follows) {
            followees.add(follow.getFollowee());
        }
        return followees;
    }

    public List<User> findFollowersById(User me) {
        //팔로위는 팔로우를 당하는 사람
        List<Follow> follows = followRepository.findAllByFollowee(me);
        List<User> followers = new ArrayList<>();
        for(Follow follow : follows) {
            followers.add(follow.getFollower());
        }
        return followers;
    }

}
