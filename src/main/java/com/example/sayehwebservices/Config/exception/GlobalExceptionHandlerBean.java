package com.example.sayehwebservices.Config.exception;

import com.github.mfathi91.time.PersianDate;
import com.github.mfathi91.time.PersianDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandlerBean {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception, WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false)
        );
        log.error(exception.getMessage());
        log.error(exception.getCause().toString());
        log.error(exception.getStackTrace().toString());
        exception.printStackTrace();
        return new ResponseEntity(
                errorResponse,
                HttpStatus.NOT_FOUND
        );

    }


    @ExceptionHandler(DecileInfoCodedException.class)
    public ResponseEntity<?> handleDecileExceptions(DecileInfoCodedException exception, WebRequest request) {

        DecileErrorResponse decileErrorResponse = new DecileErrorResponse(
                PersianDateTime.fromGregorian(LocalDateTime.now()),
                exception.getMsg(),
                exception.getErrorCode()
        );

        exception.printStackTrace();
        return new ResponseEntity(
                decileErrorResponse,
                HttpStatus.NOT_FOUND
        );

    }

}
