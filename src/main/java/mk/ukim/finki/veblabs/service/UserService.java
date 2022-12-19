package mk.ukim.finki.veblabs.service;

import mk.ukim.finki.veblabs.exception.NonExistentUserException;
import mk.ukim.finki.veblabs.model.User;

import java.time.LocalDate;

public interface UserService {
    User login(String username, String password) throws NonExistentUserException;
    User findByUsername(String username) throws NonExistentUserException;
    User save(String username, String name, String surname, String password, LocalDate dateOfBirth);
}
