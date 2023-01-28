package com.fake.bank.backend.rest.exception.handler;

import com.fake.bank.backend.common.exception.FakeBankException;
import com.fake.bank.backend.common.exception.type.FakeBankErrorType;
import com.fake.bank.backend.rest.exception.model.FakeBankError;
import com.fake.bank.backend.rest.exception.utility.Helper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class FakeBankExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        FakeBankError error = Helper.mapToFakeBankError(FakeBankErrorType.FB_001, request);
        return handleExceptionInternal(ex, error,
                new HttpHeaders(), error.getStatus(), request);
    }

    @ExceptionHandler(value = {FakeBankException.class})
    protected ResponseEntity<Object> handleFakeBankException(FakeBankException exception, WebRequest request) {
        FakeBankError error = Helper.mapToFakeBankError(exception.getErrorType(), request);
        return handleExceptionInternal(exception, error, new HttpHeaders(), error.getStatus(), request);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleGenericException(Exception exception, WebRequest request) {
        FakeBankError error = Helper.mapToFakeBankError(FakeBankErrorType.FB_599, request);
        return handleExceptionInternal(exception, error, new HttpHeaders(), error.getStatus(), request);
    }

}
