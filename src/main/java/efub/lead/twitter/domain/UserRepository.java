package efub.lead.twitter.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserId(Long id);
    User findUserByTwitterId(String twitterId);
}
