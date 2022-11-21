package mk.ukim.finki.veblabs.model;

import lombok.Data;

@Data
public class Order {
    String balloonColor;
    String balloonSize;
    String clientName;
    String clientAddress;
    Long orderId;

    public Order(String balloonColor, String clientName, String address) {
        this.balloonColor = balloonColor;
        this.clientName = clientName;
        this.clientAddress = address;
    }

    public Order(String balloonColor) {
        this.balloonColor = balloonColor;
    }
}
