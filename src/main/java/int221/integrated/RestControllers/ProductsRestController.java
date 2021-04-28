package int221.integrated.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import int221.integrated.Repositories.ProductsRepository;
import int221.integrated.models.Products;

@RestController
public class ProductsRestController {
	@Autowired
	private ProductsRepository productsRepository;

	public ProductsRestController() {
	}

	@GetMapping("/api/product")
	public List<Products> product() {
		return productsRepository.findAll();
	}

	@GetMapping("/api/show/{productCode}") // URL ให้ไม่ซ้ำของเดิมเดี่ยวค่อยเปลี่ยนทีหลัง
	public Products show(@PathVariable String id) {
		return productsRepository.findById(id).orElse(null);
	}

}
