package mk.ukim.finki.veblabs.service;

import mk.ukim.finki.veblabs.model.Balloon;
import mk.ukim.finki.veblabs.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
    public List<Manufacturer> findAll();
    Optional<Manufacturer> findById(Long id);
    Manufacturer save(String name, String country, String address);

}
