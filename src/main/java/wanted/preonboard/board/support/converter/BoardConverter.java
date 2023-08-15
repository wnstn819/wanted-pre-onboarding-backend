package wanted.preonboard.board.support.converter;


import lombok.experimental.UtilityClass;
import wanted.preonboard.board.entity.BoardEntity;
import wanted.preonboard.board.model.request.BoardCreateRequest;
import wanted.preonboard.user.entity.UserEntity;

@UtilityClass
public class BoardConverter {

    public static BoardEntity to(BoardCreateRequest request, Long id) {
        return BoardEntity.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .createId(id)
                .build();
    }

}
