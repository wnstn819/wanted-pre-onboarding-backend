package wanted.preonboard.board.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wanted.preonboard.board.model.request.BoardCreateRequest;
import wanted.preonboard.board.service.BoardService;
import wanted.preonboard.user.model.request.UserJoinRequest;
import wanted.preonboard.user.support.ApiResponse;
import wanted.preonboard.user.support.ApiResponseGenerator;
import wanted.preonboard.user.support.MessageCode;

@Controller
@RequiredArgsConstructor // final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성해주는 롬복 어노테이션
@RequestMapping("/api/v1/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping()
    public ApiResponse<ApiResponse.SuccessBody<Void>> findBoard(@RequestBody UserJoinRequest request){

        return ApiResponseGenerator.success(HttpStatus.OK, MessageCode.SUCCESS);
    }

    @PostMapping()
    public ApiResponse<ApiResponse.SuccessBody<Void>> createBoard(@RequestHeader("Token") String token, @RequestBody BoardCreateRequest request){
        boardService.create(token,request);
        return ApiResponseGenerator.success(HttpStatus.OK, MessageCode.SUCCESS);
    }

    @PutMapping()
    public ApiResponse<ApiResponse.SuccessBody<Void>> updateBoard(@RequestBody UserJoinRequest request){


        return ApiResponseGenerator.success(HttpStatus.OK, MessageCode.SUCCESS);
    }

    @DeleteMapping()
    public ApiResponse<ApiResponse.SuccessBody<Void>> deleteBoard(@RequestBody UserJoinRequest request){


        return ApiResponseGenerator.success(HttpStatus.OK, MessageCode.SUCCESS);
    }

}
