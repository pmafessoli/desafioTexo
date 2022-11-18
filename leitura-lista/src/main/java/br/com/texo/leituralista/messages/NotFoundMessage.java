package br.com.texo.leituralista.messages;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundMessage extends RuntimeException {

	public NotFoundMessage(String exception) {
		super(exception);
	}

}
