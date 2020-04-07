package by.epam.webproject.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RuntimeExceptionHandler {

    @ExceptionHandler(value = CustomRuntimeException.class)
    public ResponseEntity<ErrorResponse> handleError(CustomRuntimeException exception) {
        return ResponseEntity.badRequest().body(new ErrorResponse(400,
                exception.getExceptionCode().name(), exception.getMessage()));
    }

}
