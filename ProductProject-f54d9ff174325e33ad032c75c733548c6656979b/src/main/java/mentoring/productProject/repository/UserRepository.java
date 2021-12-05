package mentoring.productProject.repository;

import mentoring.productProject.resource.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
