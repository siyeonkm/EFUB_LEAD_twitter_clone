package efub.lead.twitter.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Long> findAllByFollowee(Long user_id);

    List<Long> findAllByFollower(Long user_id);
}
