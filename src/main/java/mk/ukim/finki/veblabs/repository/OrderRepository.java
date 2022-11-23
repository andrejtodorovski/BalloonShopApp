package mk.ukim.finki.veblabs.repository;

import mk.ukim.finki.veblabs.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    List<Order> orderList;

    public OrderRepository() {
        orderList = new ArrayList<>();
    }
    public List<Order> findAll(){
        return orderList;
    }
    public Order placeOrder(String balloonColor, String clientName, String clientAddress){
        return new Order(balloonColor,clientName,clientAddress);
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }
}
