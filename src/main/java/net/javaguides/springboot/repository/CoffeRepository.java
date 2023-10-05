package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Coffe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeRepository extends JpaRepository<Coffe, Long> {
}
