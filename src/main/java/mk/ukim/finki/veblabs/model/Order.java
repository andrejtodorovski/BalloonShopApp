package mk.ukim.finki.veblabs.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    String balloonColor;
    String balloonSize;
    String dateCreated;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    User user;

    public Order(String balloonColor, String balloonSize, User user, LocalDateTime ldt) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.user = user;
        this.dateCreated = String.valueOf(ldt);
    }

    public Order(String balloonColor) {
        this.balloonColor = balloonColor;
    }

    public Order() {

    }

    public String getBalloonColor() {
        return balloonColor;
    }

    public void setBalloonColor(String balloonColor) {
        this.balloonColor = balloonColor;
    }

    public String getBalloonSize() {
        return balloonSize;
    }

    public void setBalloonSize(String balloonSize) {
        this.balloonSize = balloonSize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
