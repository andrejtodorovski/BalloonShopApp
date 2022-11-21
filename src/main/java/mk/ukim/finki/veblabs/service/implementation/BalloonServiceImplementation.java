package mk.ukim.finki.veblabs.service.implementation;

import mk.ukim.finki.veblabs.exception.NonExistentManufacturerException;
import mk.ukim.finki.veblabs.model.Balloon;
import mk.ukim.finki.veblabs.model.Manufacturer;
import mk.ukim.finki.veblabs.repository.BalloonRepository;
import mk.ukim.finki.veblabs.repository.ManufacturerRepository;
import mk.ukim.finki.veblabs.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImplementation implements BalloonService {
    private final BalloonRepository balloonRepository;
    private final ManufacturerRepository manufacturerRepository;

    public BalloonServiceImplementation(BalloonRepository balloonRepository, ManufacturerRepository manufacturerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }

    @Override
    public void deleteByName(String name) {
        balloonRepository.deleteByName(name);
    }

    @Override
    public void deleteById(Long id) {
        balloonRepository.deleteById(id);
    }

    @Override
    public void create(String name, String description, Long manufacturerId) {
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new NonExistentManufacturerException(manufacturerId));
        balloonRepository.saveBalloon(name, description, manufacturer);
    }

    @Override
    public Optional<Balloon> update(String name, String description, Long manufacturerId) {
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new NonExistentManufacturerException(manufacturerId));
        return balloonRepository.saveBalloon(name,description,manufacturer);
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return balloonRepository.findById(id);
    }
}
