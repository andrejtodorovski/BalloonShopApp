package mk.ukim.finki.veblabs.service.implementation;

import mk.ukim.finki.veblabs.model.Balloon;
import mk.ukim.finki.veblabs.repository.BalloonRepository;
import mk.ukim.finki.veblabs.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BalloonServiceImplementation implements BalloonService {
    private final BalloonRepository balloonRepository;

    public BalloonServiceImplementation(BalloonRepository balloonRepository) {
        this.balloonRepository = balloonRepository;
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
    public void delete(String name) {
        balloonRepository.deleteBalloon(name);
    }

    @Override
    public Balloon create(String name, String description) {
        return balloonRepository.saveBalloon(new Balloon(name,description));
    }

    @Override
    public Balloon update(String name, String description) {
        return balloonRepository.saveBalloon(new Balloon(name,description));
    }
}
