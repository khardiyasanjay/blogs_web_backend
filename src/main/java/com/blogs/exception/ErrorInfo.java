package com.blogs.exception;

import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;
@Data
@Setter
public class ErrorInfo {

    private String errorMessage;
    private Integer errorCode;
    private LocalDateTime timeStamp;
}
