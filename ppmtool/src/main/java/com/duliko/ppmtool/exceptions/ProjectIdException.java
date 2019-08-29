package com.duliko.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ProjectIdException extends RuntimeException {

	private static final long serialVersionUID = -5163303227600565962L;

	public ProjectIdException(String message) {
		super(message);
	}
}
