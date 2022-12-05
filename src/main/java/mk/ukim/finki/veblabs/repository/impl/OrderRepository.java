package mk.ukim.finki.veblabs.repository.impl;

import mk.ukim.finki.veblabs.model.Order;
import mk.ukim.finki.veblabs.repository.OrderJpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
    List<Order> orderList;

    public OrderRepository() {
        orderList = new ArrayList<>();
    }
    public List<Order> findAll(){
        return orderList;
    }
    public Order placeOrder(String balloonColor){
        return new Order(balloonColor);
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

}
