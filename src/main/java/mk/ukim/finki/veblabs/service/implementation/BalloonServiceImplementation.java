package mk.ukim.finki.veblabs.service.implementation;

import mk.ukim.finki.veblabs.exception.NonExistentManufacturerException;
import mk.ukim.finki.veblabs.model.Balloon;
import mk.ukim.finki.veblabs.model.Manufacturer;
import mk.ukim.finki.veblabs.repository.BalloonJpaRepository;
import mk.ukim.finki.veblabs.repository.ManufacturerJpaRepository;
import mk.ukim.finki.veblabs.repository.impl.ManufacturerRepository;
import mk.ukim.finki.veblabs.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImplementation implements BalloonService {
    private final BalloonJpaRepository balloonJpaRepository;
    private final ManufacturerJpaRepository manufacturerJpaRepository;

    public BalloonServiceImplementation(BalloonJpaRepository balloonJpaRepository, ManufacturerJpaRepository manufacturerJpaRepository) {
        this.balloonJpaRepository = balloonJpaRepository;
        this.manufacturerJpaRepository = manufacturerJpaRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonJpaRepository.findAll();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonJpaRepository.findAllByNameOrDescription(text,text);
    }

    @Override
    public void deleteByName(String name) {
        balloonJpaRepository.deleteByName(name);
    }

    @Override
    public void deleteById(Long id) {
        balloonJpaRepository.deleteById(id);
    }

    @Override
    public void deleteByDescription(String description) {
        balloonJpaRepository.deleteByDescription(description);
    }

    @Override
    public void create(String name, String description, Long manufacturerId) {
        Manufacturer manufacturer = manufacturerJpaRepository.findById(manufacturerId)
                .orElseThrow(() -> new NonExistentManufacturerException(manufacturerId));
        balloonJpaRepository.save(new Balloon(name, description, manufacturer));
    }

    @Override
    public Balloon update(String name, String description, Long manufacturerId) {
        Manufacturer manufacturer = manufacturerJpaRepository.findById(manufacturerId)
                .orElseThrow(() -> new NonExistentManufacturerException(manufacturerId));
        return balloonJpaRepository.save(new Balloon(name,description,manufacturer));
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return balloonJpaRepository.findById(id);
    }
}
