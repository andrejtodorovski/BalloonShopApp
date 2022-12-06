package mk.ukim.finki.veblabs.service.implementation;

import mk.ukim.finki.veblabs.model.Manufacturer;
import mk.ukim.finki.veblabs.repository.ManufacturerJpaRepository;
import mk.ukim.finki.veblabs.repository.impl.ManufacturerRepository;
import mk.ukim.finki.veblabs.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImplementation implements ManufacturerService {
    private final ManufacturerJpaRepository manufacturerJpaRepository;

    public ManufacturerServiceImplementation(ManufacturerJpaRepository manufacturerJpaRepository) {
        this.manufacturerJpaRepository = manufacturerJpaRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerJpaRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return manufacturerJpaRepository.findById(id);
    }

    @Override
    public Manufacturer save(String name, String country, String address) {
        return manufacturerJpaRepository.save(new Manufacturer(name,country,address));
    }
}
