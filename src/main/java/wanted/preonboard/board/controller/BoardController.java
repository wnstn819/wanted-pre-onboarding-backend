package wanted.preonboard.board.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wanted.preonboard.board.entity.BoardEntity;
import wanted.preonboard.board.model.request.BoardCreateRequest;
import wanted.preonboard.board.model.request.BoardUpdateRequest;
import wanted.preonboard.board.service.BoardService;
import wanted.preonboard.user.model.request.UserJoinRequest;
import wanted.preonboard.user.support.ApiResponse;
import wanted.preonboard.user.support.ApiResponseGenerator;
import wanted.preonboard.user.support.MessageCode;

import java.util.*;

@Controller
@RequiredArgsConstructor // final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성해주는 롬복 어노테이션
@RequestMapping("/api/v1/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping()
    public ApiResponse<ApiResponse.SuccessBody<Page<BoardEntity>>> findBoard(@RequestParam(defaultValue = "0") Long boardId, @PageableDefault(size=10, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<BoardEntity> posts = boardService.findList(boardId,pageable);
        return ApiResponseGenerator.success(posts,HttpStatus.OK, MessageCode.SUCCESS);
    }

    @PostMapping()
    public ApiResponse<ApiResponse.SuccessBody<Void>> createBoard(@RequestHeader("Token") String token, @RequestBody BoardCreateRequest request){
        boardService.create(token,request);
        return ApiResponseGenerator.success(HttpStatus.OK, MessageCode.SUCCESS);
    }

    @PutMapping()
    public ApiResponse<ApiResponse.SuccessBody<BoardEntity>> updateBoard(@RequestHeader("Token") String token,@RequestBody BoardUpdateRequest request){
        return ApiResponseGenerator.success(boardService.update(token,request),HttpStatus.OK, MessageCode.SUCCESS);
    }

    @DeleteMapping()
    public ApiResponse<ApiResponse.SuccessBody<Void>> deleteBoard(@RequestBody UserJoinRequest request){


        return ApiResponseGenerator.success(HttpStatus.OK, MessageCode.SUCCESS);
    }

}
