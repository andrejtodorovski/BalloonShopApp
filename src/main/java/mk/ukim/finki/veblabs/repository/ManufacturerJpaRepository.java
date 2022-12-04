package mk.ukim.finki.veblabs.repository;

import mk.ukim.finki.veblabs.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerJpaRepository extends JpaRepository<Manufacturer,Long> {
}
