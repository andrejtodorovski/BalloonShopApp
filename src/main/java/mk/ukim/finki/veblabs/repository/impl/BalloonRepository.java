package mk.ukim.finki.veblabs.repository.impl;

import mk.ukim.finki.veblabs.model.Balloon;
import mk.ukim.finki.veblabs.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
@Repository
public class BalloonRepository {
    List<Balloon> balloonList = new ArrayList<>(10);

    public BalloonRepository() {
        Manufacturer m = new Manufacturer("Andrej","MKD","Radishani");
        balloonList.add(new Balloon("test","test1",m));
        balloonList.add(new Balloon("balon4e","balon4e1",m));
    }

    public List<Balloon> findAllBalloons(){
        return balloonList;
    }
    public List<Balloon> findAllByNameOrDescription(String text){
        return balloonList.stream()
                .filter(b -> b.getName().contains(text) || b.getDescription().contains(text))
                .collect(Collectors.toList());
    }
    public Optional<Balloon> findByName(String name){
        return balloonList.stream()
                .filter(balloon -> Objects.equals(balloon.getName(), "name"))
                .findFirst();
    }
    public Optional<Balloon> saveBalloon(String name, String description, Manufacturer manufacturer){
        balloonList.removeIf(balloon -> balloon.getName().equals(name));
        Balloon b = new Balloon(name,description,manufacturer);
        balloonList.add(b);
        return Optional.of(b);
    }
    public Optional<Balloon> findById(Long id){
        return balloonList.stream().filter(balloon -> balloon.getId().equals(id)).findFirst();
    }
    public void deleteByName(String name){
        balloonList.removeIf(balloon -> balloon.getName().equals(name));
    }
    public void deleteById(Long id){
        balloonList.removeIf(balloon -> balloon.getId().equals(id));
    }
}
