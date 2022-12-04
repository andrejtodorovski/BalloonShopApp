package mk.ukim.finki.veblabs.service;

import mk.ukim.finki.veblabs.exception.NonExistentUserException;
import mk.ukim.finki.veblabs.model.User;

public interface UserService {
    User login(String username, String password) throws NonExistentUserException;
}
