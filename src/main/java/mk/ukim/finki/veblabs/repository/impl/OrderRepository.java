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
    private final OrderJpaRepository orderJpaRepository;

    public OrderRepository(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
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
    List<Order> findAllByTime(LocalDateTime from, LocalDateTime to){
        return orderJpaRepository.findAll().stream().filter(order -> LocalDateTime.parse(order.getDateCreated()).isBefore(to) && LocalDateTime.parse(order.getDateCreated()).isAfter(from)).collect(Collectors.toList());
    }
}
