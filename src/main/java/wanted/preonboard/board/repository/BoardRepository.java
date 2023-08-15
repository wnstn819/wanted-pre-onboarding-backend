package wanted.preonboard.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import wanted.preonboard.board.entity.BoardEntity;
import wanted.preonboard.user.entity.UserEntity;

import java.util.*;

public interface BoardRepository extends JpaRepository<BoardEntity,Long> {

    Page<BoardEntity> findAll(Pageable pageable);
    Page<BoardEntity> findById(Long boardId, Pageable pageable);


}
