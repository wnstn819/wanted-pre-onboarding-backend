package wanted.preonboard.user.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import wanted.preonboard.user.model.Token;
import wanted.preonboard.user.model.request.UserJoinRequest;
import wanted.preonboard.user.service.UserService;
import wanted.preonboard.user.support.ApiResponse;
import wanted.preonboard.user.support.ApiResponseGenerator;
import wanted.preonboard.user.support.MessageCode;

@Controller
@RequiredArgsConstructor // final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성해주는 롬복 어노테이션
@RequestMapping("/api/v1")
public class UserController {

    // repository
    private final UserService userService;
    //apiResponseEntity
    @PostMapping("/join")
    public ApiResponse<ApiResponse.SuccessBody<Void>> userJoin(@RequestBody UserJoinRequest request){
        System.out.println("test");

        userService.join(request.getEmail(),request.getPassword());

        return ApiResponseGenerator.success(HttpStatus.OK, MessageCode.SUCCESS);
    }

    @PostMapping("/login")
    public ApiResponse<ApiResponse.SuccessBody<Token>> userLogin(@RequestBody UserJoinRequest request){
        return ApiResponseGenerator.success(userService.login(request.getEmail(),request.getPassword()),HttpStatus.OK, MessageCode.SUCCESS);
    }
}
