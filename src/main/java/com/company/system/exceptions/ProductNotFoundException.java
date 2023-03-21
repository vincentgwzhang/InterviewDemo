package com.company.system.exceptions;

import com.company.controller.handler.HttpException;

public class ProductNotFoundException extends HttpException {

    public ProductNotFoundException(Integer code){
        this.code =code;
        this.httpStatusCode =404;
    }
}
