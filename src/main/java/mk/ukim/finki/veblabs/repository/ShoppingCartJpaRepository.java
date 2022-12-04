package mk.ukim.finki.veblabs.repository;

import mk.ukim.finki.veblabs.model.Order;
import mk.ukim.finki.veblabs.model.ShoppingCart;
import mk.ukim.finki.veblabs.model.User;
import mk.ukim.finki.veblabs.service.ShoppingCartService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartJpaRepository extends JpaRepository<ShoppingCart,Long> {
    ShoppingCart findByUser(User user);
}
