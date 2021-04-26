package com.property.application.exception;




import com.property.application.constant.StatusConstants;

import lombok.Getter;

@Getter
public class UnAuthorizedException extends RuntimeException {
    private StatusConstants.HttpConstants status;

    public UnAuthorizedException(StatusConstants.HttpConstants status) {
        super(status.getDesc(), null);
        this.status = status;
    }
}
