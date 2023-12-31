package net.javaguides.springboot.web;

import net.javaguides.springboot.model.Coffe;
import net.javaguides.springboot.service.CoffeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class MainController {
	@Autowired
	private CoffeService coffeService;

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/menu")
	public String menu(Model model) {
		List<Coffe> coffees = coffeService.getAllCoffe();
		model.addAttribute("coffees", coffees);
		return "menu";
	}

	@GetMapping("/services")
	public String services() {
		return "services";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	@GetMapping("/sign-in")
	public String login() {
		return "sign-in";
	}


	@GetMapping("/")
	public String home(Authentication authentication, Model model) {
		if (authentication != null && authentication.getAuthorities().stream()
				.anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"))) {
			return "redirect:/admin"; // Перенаправление для пользователей с ролью "ROLE_ADMIN" на страницу /admin
		}
		List<Coffe> coffees = coffeService.getAllCoffe();
		model.addAttribute("coffees", coffees);

		return "index"; // Перенаправление для всех остальных пользователей на страницу /index
	}
}


