package net.javaguides.springboot.service;
import net.javaguides.springboot.model.Coffe;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CoffeService {
    List<Coffe> getAllCoffe();
    void saveCoffe(Coffe coffe);
    Coffe getCoffeById(long id);
    void deleteCoffeById(long id);
    Page<Coffe> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
