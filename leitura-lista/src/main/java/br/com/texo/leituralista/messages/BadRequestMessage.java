package br.com.texo.leituralista.messages;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestMessage extends RuntimeException {

	public BadRequestMessage(String exception) {
		super(exception);
	}

}
