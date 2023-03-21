package com.company.controller.handler;

import com.company.configuration.ExceptionCodeConfiguration;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BusinessExceptionHandler {

    @Autowired
    private ExceptionCodeConfiguration configuration;

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest request , HttpException e){
        Integer code = e.getCode();
        Integer httpStatusCode = e.getHttpStatusCode();
        UnifyResponse unifyResponse= new  UnifyResponse(code,this.getMessageByCode(code),request.getMethod()+" "+request.getRequestURI());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus status = HttpStatus.resolve(httpStatusCode);
        return new ResponseEntity<>(unifyResponse,headers,status);
    }

    private String getMessageByCode(Integer code){
        return configuration.getMessage(code);
    }

}
