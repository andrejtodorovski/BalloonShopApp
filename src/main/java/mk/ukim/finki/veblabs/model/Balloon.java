package mk.ukim.finki.veblabs.model;

import lombok.Data;

@Data
public class Balloon {
    String name;
    String description;
    Long id;
    Manufacturer manufacturer;
    public Balloon(String name, String description, Manufacturer manufacturer) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
    }
}
