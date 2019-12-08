package iandrew40.easycooking.data.repositories;

import iandrew40.easycooking.data.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {

    Post findByName(String postName);
}
