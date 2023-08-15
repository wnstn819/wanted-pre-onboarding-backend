package wanted.preonboard.board.service;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wanted.preonboard.board.model.request.BoardCreateRequest;
import wanted.preonboard.board.repository.BoardRepository;
import wanted.preonboard.board.support.converter.BoardConverter;
import wanted.preonboard.config.WebSecurityConfig;
import wanted.preonboard.user.entity.UserEntity;
import wanted.preonboard.user.model.Token;
import wanted.preonboard.user.repository.UserRepository;
import wanted.preonboard.user.support.converter.UserConverter;
import wanted.preonboard.util.TokenGenerator;
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
}
