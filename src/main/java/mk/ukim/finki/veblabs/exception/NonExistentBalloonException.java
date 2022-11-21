package mk.ukim.finki.veblabs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NonExistentBalloonException extends RuntimeException {
    public NonExistentBalloonException(Long id) {
        super(String.format("Balloon with id %d doesn't exist",id));
    }
}