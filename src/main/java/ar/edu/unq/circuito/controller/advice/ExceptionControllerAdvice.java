package ar.edu.unq.circuito.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private static final String MENSAJE_DEFAULT_ERROR_SERVER = " Ocurrió un error en el servidor. Por favor intentarlo nuevamente mas tarde.";
    private static final String MENSAJE_DEFAULT_NOT_FOUND = " No se encontró el recurso al que intenta acceder.";

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadRequest(IllegalArgumentException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException exception) {
        String errorValidacion = exception
                .getConstraintViolations()
                .stream()
                .findFirst()
                .map(ConstraintViolation::getMessage)
                .map(this::extraerCausaDeConstraintViolationException)
                .orElse(MENSAJE_DEFAULT_ERROR_SERVER);
        return new ResponseEntity<>(errorValidacion, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SocketTimeoutException.class)
    public void handleFileSizeLimitExceeded(SocketTimeoutException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.REQUEST_TIMEOUT.value(), "problemas de conexion en tu dispotivo.Intente nuevamente.");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleDefaultException(Exception exception, HttpServletResponse response) throws IOException {
        return new ResponseEntity<>(MENSAJE_DEFAULT_ERROR_SERVER, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String extraerCausaDeConstraintViolationException(String mensaje) {
        int indiceComienzoCausa = mensaje.indexOf(": ") + 1;
        return mensaje.substring(indiceComienzoCausa);
    }
}
