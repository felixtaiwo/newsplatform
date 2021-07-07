package newsplatform.backend.Repository;

import newsplatform.backend.User.User;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
   Optional<User> findByEmailAddress(String emailAddress);
   @Query(value = "SELECT userId,emailAddress,role FROM User")
   public Slice<User> findIt ();
}
