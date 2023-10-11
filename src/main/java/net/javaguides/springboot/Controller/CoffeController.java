package net.javaguides.springboot.Controller;
import net.javaguides.springboot.model.Coffe;
import net.javaguides.springboot.service.CoffeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CoffeController {
    @Autowired
    private CoffeService coffeService;

    @GetMapping("/admin")
    public String viewHomePage(Model model) {
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/admin/showNewCoffeForm")
    public String showNewCoffeForm(Model model) {

        Coffe coffe = new Coffe();
        model.addAttribute("coffe", coffe);
        return "new_coffe";
    }
    @PostMapping("/admin/saveCoffe")
    public String saveCoffe(@ModelAttribute("coffe") Coffe coffe) {

        coffeService.saveCoffe(coffe);
        return "redirect:/admin";
    }
    @GetMapping("/admin/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get product from the service
        Coffe coffe = coffeService.getCoffeById(id);

        // set product as a model attribute to pre-populate the form
        model.addAttribute("coffe", coffe);
        return "update_coffe";
    }
    @GetMapping("/admin/deleteCoffe/{id}")
    public String deleteCoffe(@PathVariable(value = "id") long id) {


        this.coffeService.deleteCoffeById(id);
        return "redirect:/admin";
    }
    @GetMapping("/admin/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;
        Page<Coffe> page = coffeService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Coffe> listCoffe = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("listCoffe", listCoffe);
        return "admin";
    }




}
