package vn.titv.spring.StudentManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vn.titv.spring.StudentManagement.entity.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    // NOT FOUND FOR STUDENT
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleStudentNotFoundException(StudentException e){
        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception e){
        ErrorResponse es = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(es);
    }
}
