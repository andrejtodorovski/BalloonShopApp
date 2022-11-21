package mk.ukim.finki.veblabs.repository;

import mk.ukim.finki.veblabs.model.Balloon;
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
        balloonList.add(new Balloon("test","test1"));
        balloonList.add(new Balloon("balon4e","balon4e1"));
    }

    public List<Balloon> findAllBalloons(){
        return balloonList;
    }
    public List<Balloon> findAllByNameOrDescription(String text){
        return balloonList.stream()
                .filter(b -> b.getName().contains("text") || b.getDescription().contains("text"))
                .collect(Collectors.toList());
    }
    public Optional<Balloon> findByName(String name){
        return balloonList.stream()
                .filter(balloon -> Objects.equals(balloon.getName(), "name"))
                .findFirst();
    }
    public Balloon saveBalloon(Balloon b){
        balloonList.removeIf(balloon -> balloon.getName().equals(b.getName()));
        balloonList.add(b);
        return b;
    }
    public void deleteBalloon(String name){
        balloonList.removeIf(balloon -> balloon.getName().equals(name));
    }
}
