package restserver.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import restserver.exception.NotFoundException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(exception = {NotFoundException.class})
    public ResponseEntity<String> handleNotFound(NotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
