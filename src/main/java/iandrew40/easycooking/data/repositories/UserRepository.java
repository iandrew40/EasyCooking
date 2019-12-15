package iandrew40.easycooking.data.repositories;

import iandrew40.easycooking.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByUsername(String username);

    User findUserByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}
