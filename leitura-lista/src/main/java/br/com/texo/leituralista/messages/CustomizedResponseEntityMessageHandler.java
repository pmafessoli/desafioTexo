package br.com.texo.leituralista.messages;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.texo.leituralista.models.StatusModel;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityMessageHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<StatusModel> handleAllExceptions(Exception ex, WebRequest request,
      HttpServletRequest request2) {
    StatusModel returnStatus = new StatusModel("00500", request2.getRequestURL().toString());
    return new ResponseEntity<>(returnStatus, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ForbiddenMessage.class)
  public final ResponseEntity<StatusModel> handleUserForbiddenException(ForbiddenMessage ex, WebRequest request,
      HttpServletRequest request2) {
    StatusModel returnStatus = new StatusModel("00403", request2.getRequestURL().toString());
    return new ResponseEntity<>(returnStatus, HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(NotFoundMessage.class)
  public final ResponseEntity<StatusModel> handleUserNotFoundException(NotFoundMessage ex, WebRequest request,
      HttpServletRequest request2) {
    StatusModel returnStatus = new StatusModel("00404", request2.getRequestURL().toString());
    return new ResponseEntity<>(returnStatus, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodNotAllowedMessage.class)
  public final ResponseEntity<StatusModel> handleMethodNotAllowedException(MethodNotAllowedMessage ex,
      WebRequest request, HttpServletRequest request2) {
    StatusModel returnStatus = new StatusModel("00405", request2.getRequestURL().toString());
    return new ResponseEntity<>(returnStatus, HttpStatus.METHOD_NOT_ALLOWED);
  }

  @ExceptionHandler(BadRequestMessage.class)
  public final ResponseEntity<StatusModel> handleBadRequestException(BadRequestMessage ex, WebRequest request,
      HttpServletRequest request2) {
    StatusModel returnStatus = new StatusModel("00400", request2.getRequestURL().toString());
    return new ResponseEntity<>(returnStatus, HttpStatus.BAD_REQUEST);
  }

}