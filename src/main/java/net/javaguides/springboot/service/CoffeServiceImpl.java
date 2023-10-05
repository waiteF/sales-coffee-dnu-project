package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Coffe;
import net.javaguides.springboot.repository.CoffeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CoffeServiceImpl implements CoffeService {
    @Autowired
    private CoffeRepository coffeRepository;
    @Override
    public List<Coffe> getAllCoffe() {
        return coffeRepository.findAll();
    }
    @Override
    public void saveCoffe(Coffe coffe) {
        this.coffeRepository.save(coffe);
    }
    @Override
    public Coffe getCoffeById(long id) {
        Optional<Coffe> optional = coffeRepository.findById(id);
        Coffe coffe = null;
        if (optional.isPresent()) {
            coffe = optional.get();
        } else {
            throw new RuntimeException(" Coffe not found for id :: " + id);
        }
        return coffe;
    }
    @Override
    public void deleteCoffeById(long id) {
        this.coffeRepository.deleteById(id);
    }
    @Override
    public Page<Coffe> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.coffeRepository.findAll(pageable);
    }

}
