package wanted.preonboard.board.service;



import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wanted.preonboard.board.entity.BoardEntity;
import wanted.preonboard.board.model.request.BoardCreateRequest;
import wanted.preonboard.board.repository.BoardRepository;
import wanted.preonboard.board.support.converter.BoardConverter;
import wanted.preonboard.util.TokenResolver;

import java.util.*;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final TokenResolver tokenResolver;

    @Override
    public void create(String token,BoardCreateRequest request) {
        Optional<Long> memberIdRe = tokenResolver.resolveToken(token);
        Long memberId = memberIdRe.get();
        boardRepository.save(BoardConverter.to(request,memberId));
    }

    @Override
    public Page<BoardEntity> findList(Long BoardId,Pageable pageable) {
        Page<BoardEntity> boardEntities=null;
        if(BoardId == 0){
            boardEntities = boardRepository.findAll(pageable);
        }else{
            boardEntities = boardRepository.findById(BoardId,pageable);
        }

        return boardEntities;
    }
}
