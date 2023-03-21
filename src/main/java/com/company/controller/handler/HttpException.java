package com.company.controller.handler;

import lombok.Data;

@Data
public class HttpException extends RuntimeException {

    protected int code;
    protected int httpStatusCode;

}
