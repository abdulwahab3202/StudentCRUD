package com.kce.response;

import com.kce.enumeration.ResponseStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommonResponce {
    private ResponseStatus status;
    private String successMessage;
    private String errorMessage;
    private Object data;
    private int code;
}