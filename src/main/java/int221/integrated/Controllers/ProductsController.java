package int221.integrated.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import int221.integrated.Repositories.ProductsRepository;

@Controller
public class ProductsController {
	@Autowired
	private ProductsRepository productsRepository;

	public ProductsController() {
	}

	@RequestMapping({ "/product" })
	public String product(Model model) {
		model.addAttribute("products", this.productsRepository.findAll());
		return "product";
	}
}
