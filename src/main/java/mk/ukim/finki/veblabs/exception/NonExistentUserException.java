package mk.ukim.finki.veblabs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class NonExistentUserException extends Exception{
    public NonExistentUserException() {
        super("Username and password are wrong");
    }
}
