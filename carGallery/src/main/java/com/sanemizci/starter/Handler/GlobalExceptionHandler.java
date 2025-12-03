package com.sanemizci.starter.Handler;

import com.sanemizci.starter.exception.BaseException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ApiError<?>> handleBaseException(BaseException e, WebRequest request) {
        return ResponseEntity.badRequest().body(createApiError(e.getMessage(), request));
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ApiError<Map<String, List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (ObjectError objectError : e.getBindingResult().getAllErrors()) {
            String fieldName;
            String errorMessage = objectError.getDefaultMessage();
            
            // FieldError ise field name'i al, değilse object name kullan
            if (objectError instanceof FieldError) {
                fieldName = ((FieldError) objectError).getField();
            } else {
                fieldName = objectError.getObjectName();
            }
            
            // Map'te field name varsa error message'ı listeye ekle, yoksa yeni liste oluştur
            if (map.containsKey(fieldName)) {
                map.get(fieldName).add(errorMessage);
            } else {
                map.put(fieldName, new ArrayList<>(Collections.singletonList(errorMessage)));
            }
        }

        return ResponseEntity.badRequest().body(createApiError(map, request));
    }

    private String getHostName() {
        try {
            return Inet4Address.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "";
    }

    public <E> ApiError<E> createApiError(E message, WebRequest request) {
        ApiError<E> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        Exception<E> exception = new Exception();
        exception.setPath(request.getDescription(false));
        exception.setCreateTime(new Date());
        exception.setMessage(message);
        exception.setHostname(getHostName());

        apiError.setException(exception);

        return apiError;
    }
}
