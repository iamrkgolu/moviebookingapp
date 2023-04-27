package com.moviebookingapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Movie Id Exception raised- handled by custom exception")
public class MovieIdAlreadyExistsExceptions extends Exception {

}
