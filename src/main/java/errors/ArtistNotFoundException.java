package errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "No Artist Could be found")
public class ArtistNotFoundException extends RuntimeException {

}
