package mk.ukim.finki.veblabs.repository.impl;

import mk.ukim.finki.veblabs.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ManufacturerRepository {
    List<Manufacturer> manufacturerList = new ArrayList<>(5);

    public ManufacturerRepository() {
        manufacturerList.add(new Manufacturer("test","test country","test address"));
        manufacturerList.add(new Manufacturer("andr","andr country", "andr address"));
    }

    public List<Manufacturer> findAll(){
        return manufacturerList;
    }
    public Optional<Manufacturer> findByName(String name){
        return manufacturerList.stream()
                .filter(Manufacturer -> Objects.equals(Manufacturer.getName(), "name"))
                .findFirst();
    }
    public Manufacturer saveManufacturer(Manufacturer b){
        manufacturerList.removeIf(Manufacturer -> Manufacturer.getName().equals(b.getName()));
        manufacturerList.add(b);
        return b;
    }
    public void deleteManufacturer(String name){
        manufacturerList.removeIf(Manufacturer -> Manufacturer.getName().equals(name));
    }
    public Optional<Manufacturer> findById(Long id){
        return manufacturerList.stream()
                .filter(Manufacturer -> Objects.equals(Manufacturer.getId(), id))
                .findFirst();
    }
}
