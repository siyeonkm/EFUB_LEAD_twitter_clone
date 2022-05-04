package efub.lead.twitter.service;

import efub.lead.twitter.domain.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;

    public List<Long> findFolloweesById(Long id) {
        //팔로위는 팔로우를 당하는 사람
        return followRepository.findAllByFollower(id);
    }

    public List<Long> findFollowersById(Long id) {
        //팔로위는 팔로우를 당하는 사람
        return followRepository.findAllByFollowee(id);
    }

}
