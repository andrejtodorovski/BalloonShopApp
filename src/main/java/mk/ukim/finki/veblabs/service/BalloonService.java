package mk.ukim.finki.veblabs.service;

import mk.ukim.finki.veblabs.model.Balloon;

import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
    void deleteByName(String name);
    void deleteById(Long id);
    void create(String name, String description, Long manufacturerId);
    Optional<Balloon> update(String name, String description, Long manufacturerId);
    Optional<Balloon> findById(Long id);
}
