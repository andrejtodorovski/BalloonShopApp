package mk.ukim.finki.veblabs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NonExistentManufacturerException extends RuntimeException {
    public NonExistentManufacturerException(Long id) {
        super(String.format("Manufacturer with id %d doesn't exist",id));
    }
}
