package br.com.texo.leituralista.messages;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenMessage extends RuntimeException {

  public ForbiddenMessage(String exception) {
    super(exception);
  }

}
