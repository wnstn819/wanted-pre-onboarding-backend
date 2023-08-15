package wanted.preonboard.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wanted.preonboard.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long> {


    UserEntity findByEmail(String email);
}
