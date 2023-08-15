package wanted.preonboard.board.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wanted.preonboard.board.entity.BoardEntity;
import wanted.preonboard.board.model.request.BoardCreateRequest;
import wanted.preonboard.board.model.request.BoardUpdateRequest;
import wanted.preonboard.user.model.Token;

import java.util.*;

public interface BoardService {
    public void create(String token,BoardCreateRequest request);

    Page<BoardEntity> findList(Long boardId,Pageable pageable);

    public BoardEntity update(String token, BoardUpdateRequest request);

    public void delete(String token, Long boardId);

}
