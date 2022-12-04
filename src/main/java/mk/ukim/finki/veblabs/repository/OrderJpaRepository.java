package mk.ukim.finki.veblabs.repository;

import mk.ukim.finki.veblabs.model.Order;
import mk.ukim.finki.veblabs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderJpaRepository extends JpaRepository<Order,Long> {
    List<Order> findAllByUser(User user);

}
