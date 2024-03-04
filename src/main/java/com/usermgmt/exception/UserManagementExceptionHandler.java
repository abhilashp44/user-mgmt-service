package com.usermgmt.exception;

import com.usermgmt.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserManagementExceptionHandler {

    @ExceptionHandler({RecordAlreadyExistException.class})
    public ResponseEntity<ExceptionResponse> handleEntityAlreadyExistsException(RecordAlreadyExistException exception) {

        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(HttpStatus.BAD_REQUEST.toString());
        response.setErrorMessage("User Already Exists");
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
}
