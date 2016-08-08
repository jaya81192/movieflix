package io.egen.movieflix_server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class AlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 405802649322364762L;

	public AlreadyExistsException(String message) {
		super(message);
	}

	public AlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
