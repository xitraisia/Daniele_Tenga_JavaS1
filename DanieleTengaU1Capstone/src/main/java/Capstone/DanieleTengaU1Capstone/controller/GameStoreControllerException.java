//package Capstone.DanieleTengaU1Capstone.controller;
//
//import Capstone.DanieleTengaU1Capstone.exception.NotFoundException;
//import Capstone.DanieleTengaU1Capstone.model.CustomeErrorResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.time.LocalDateTime;
//
//@RestControllerAdvice
//public class GameStoreControllerException {
//
//    @ExceptionHandler(value =   NotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<CustomeErrorResponse> notFoundException(NotFoundException e) {
//        CustomeErrorResponse error = new CustomeErrorResponse(HttpStatus.NOT_FOUND.toString(), e.getMessage());
//        error.setStatus((HttpStatus.NOT_FOUND.value()));
//        error.setTimestamp(LocalDateTime.now());
//        ResponseEntity<CustomeErrorResponse> responseEntity = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//        return responseEntity;
//    }
//}
