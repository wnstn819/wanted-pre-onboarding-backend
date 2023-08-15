package wanted.preonboard.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wanted.preonboard.board.entity.BoardEntity;
import wanted.preonboard.user.entity.UserEntity;

public interface BoardRepository extends JpaRepository<BoardEntity,Long> {

}
