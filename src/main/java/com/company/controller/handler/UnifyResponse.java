package com.company.controller.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnifyResponse {

    private Integer code;

    private String message;

    private String request;

}