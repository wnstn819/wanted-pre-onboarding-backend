package wanted.preonboard.board.service;

import wanted.preonboard.board.model.request.BoardCreateRequest;
import wanted.preonboard.user.model.Token;

public interface BoardService {
    public void create(String token,BoardCreateRequest request);


}
