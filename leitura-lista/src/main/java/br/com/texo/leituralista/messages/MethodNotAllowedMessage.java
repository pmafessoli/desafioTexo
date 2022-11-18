package br.com.texo.leituralista.messages;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class MethodNotAllowedMessage extends RuntimeException {

	public MethodNotAllowedMessage(String exception) {
		super(exception);
	}

}
