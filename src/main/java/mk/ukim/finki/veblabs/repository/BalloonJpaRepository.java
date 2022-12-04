package mk.ukim.finki.veblabs.repository;

import mk.ukim.finki.veblabs.model.Balloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalloonJpaRepository extends JpaRepository<Balloon,Long> {
    void deleteByName(String name);
    List<Balloon> findBalloonsByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);
}
