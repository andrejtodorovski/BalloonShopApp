package mk.ukim.finki.veblabs.model;

import lombok.Data;

@Data
public class Balloon {
    String name;
    String description;
    Long id;
    public Balloon(String name, String description) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
    }
}
