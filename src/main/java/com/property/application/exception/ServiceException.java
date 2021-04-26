package com.property.application.exception;




import com.property.application.constant.StatusConstants;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {
    private StatusConstants.HttpConstants status;

    public ServiceException(StatusConstants.HttpConstants status) {
        super(status.getDesc(), null);
        this.status = status;
    }
}
