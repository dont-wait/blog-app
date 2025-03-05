package com.dontwait.blog.exception;

import com.dontwait.blog.payloads.request.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.View;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private final View error;

    public GlobalExceptionHandler(View error) {
        this.error = error;
    }

    //TH NGoai le - ko bt trc dinh exception nay`
    @ExceptionHandler(value= RuntimeException.class)
//    ResponseEntity<String> handlingRuntimeException(RuntimeException e){
//        return ResponseEntity.badRequest().body(e.getMessage());
//    }
    ResponseEntity<ApiResponse> handlingRunTimeException(RuntimeException e){
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = AppException.class)
    //ResponseEntity include: Code, message, (body JSON) but in this case just error sending to FE,
    // we need to controller that error
    ResponseEntity<ApiResponse> handlingRunTimeException(AppException appException){
        ApiResponse apiResponse = new ApiResponse(); //extend Exception.class,
                                                     // we customizing it for best case or rule in project

        ErrorCode errorCode = appException.getErrorCode();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingValidation(MethodArgumentNotValidException e){
        String enumKey = e.getFieldError().getDefaultMessage();

        ErrorCode errorCode = ErrorCode.INVALID_ID_KEY;
        try {
            errorCode = ErrorCode.valueOf(enumKey);
        }
        catch (IllegalArgumentException e1) {
        }

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
}
