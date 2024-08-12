package com.paul.sentiment.exception;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class ErrorResponse {
    private String msg;
    private int status;
}
