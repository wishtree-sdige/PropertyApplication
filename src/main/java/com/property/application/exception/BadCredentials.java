package com.property.application.exception;



import com.property.application.constant.StatusConstants;

import lombok.Getter;
@Getter
public class BadCredentials extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StatusConstants.HttpConstants status;

    public BadCredentials(StatusConstants.HttpConstants status) {
        super(status.getDesc(), null);
        this.status = status;
    } 

}
