package org.my.skeleton.exception.handler;

import org.my.skeleton.client.common.Response;
import org.my.skeleton.client.common.ResponseCode;
import org.my.skeleton.exception.BizException;
import org.my.skeleton.exception.ParamException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Response<Void> handleException(HttpServletRequest req, Exception e){
        if(e instanceof ParamException){
            return new Response<>(ResponseCode.PARAM_ERROR,e.getMessage());
        }else if(e instanceof BizException){
            return new Response<>(ResponseCode.BIZ_EXCEPTION,e.getMessage());
        }else {
            return new Response<>(ResponseCode.SERVER_ERROR,e.getMessage());
        }
    }
}
