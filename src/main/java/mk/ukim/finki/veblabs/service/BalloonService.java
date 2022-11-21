package mk.ukim.finki.veblabs.service;

import mk.ukim.finki.veblabs.model.Balloon;

import java.util.List;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
    void delete(String name);
    Balloon create(String name,String description);
    Balloon update(String name, String description);
}
