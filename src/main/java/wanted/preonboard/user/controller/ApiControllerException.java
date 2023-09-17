package wanted.preonboard.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import wanted.preonboard.user.support.ApiResponse;
import wanted.preonboard.user.support.ApiResponseGenerator;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ApiControllerException {
    private final LoggingHandler loggingHandler;
    private static final String FAIL_CODE = "fail";

    @ExceptionHandler(Exception.class)
    public ApiResponse<ApiResponse.FailureBody> handleException(Exception ex, HttpServletRequest request) {
        loggingHandler.writeLog(ex, request);
        return ApiResponseGenerator.fail(FAIL_CODE, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ApiResponse<ApiResponse.FailureBody> handleJoinException(Exception ex, HttpServletRequest request) {
        loggingHandler.writeLog(ex, request);
        return ApiResponseGenerator.fail(FAIL_CODE, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ApiResponse<ApiResponse.FailureBody> handleUpdateException(Exception ex, HttpServletRequest request) {
        loggingHandler.writeLog(ex, request);
        return ApiResponseGenerator.fail(FAIL_CODE, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
