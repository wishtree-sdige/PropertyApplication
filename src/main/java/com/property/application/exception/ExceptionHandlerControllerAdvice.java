package com.property.application.exception;


import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.property.application.constant.StatusConstants;
import com.property.application.response.Response;
import com.property.application.response.Status;


@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {


    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    Response<?> handleServiceException(final ServiceException exception) {

        Status status = new Status(exception.getStatus());
        return new Response<>(status, null);

    }
    @ExceptionHandler(UnAuthorizedException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public @ResponseBody
    Response<?> handleServiceException(final UnAuthorizedException exception) {

        Status status = new Status(exception.getStatus());
        return new Response<>(status, null);

    }
    @ExceptionHandler(CanNotGetResponseException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    Response<?> handleResponseException(final CanNotGetResponseException exception) {
        Status status = new Status(exception.getStatus());
        return new Response<>(status, null);

    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    Response<?> handleNotFoundException(final NotFoundException exception) {
        Status status = new Status(exception.getStatus());
        return new Response<>(status, null);

    }

    @ExceptionHandler(ConnectionTimeoutException.class)
    @ResponseStatus(value = HttpStatus.GATEWAY_TIMEOUT)
    public @ResponseBody
    Response<?> handleConnectionException(final ConnectionTimeoutException exception) {
        Status status = new Status(exception.getStatus());
        return new Response<>(status, null);

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    Response<?> internalServerException(final Exception exception) {

        Status status = new Status(StatusConstants.HttpConstants.INTERNAL_SERVER_ERROR);
        return new Response<>(status, null);

    }
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	  public final ResponseEntity<Object> handleConstraintViolationExceptions(
	      final ConstraintViolationException ex) {
		 Status errorDetail = new Status(StatusConstants.HttpConstants.CUSTOM_FIELD_VALIDATION.getCode(),
	                ex.getMessage());
	        return new ResponseEntity(new Response(errorDetail, null), HttpStatus.BAD_REQUEST);
	  }
}
