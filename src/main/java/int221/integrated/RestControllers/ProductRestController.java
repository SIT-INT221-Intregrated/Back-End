package int221.integrated.RestControllers;

import int221.integrated.Repositories.ProductsJpaRepository;
import int221.integrated.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:8080" })
@RestController // คลาสนี้เป็น Controller ของ API
public class ProductRestController {
	@Autowired
	private ProductsJpaRepository productsJpaRepository;

	@GetMapping("/products")
	public List<Products> showAllProducts() {
		return productsJpaRepository.findAll();
	}

	@GetMapping("/products/{productcode}")
	public Products showProduct(@PathVariable String productcode) {
		return this.productsJpaRepository.findById(productcode).orElse(null);
	}

	/*
	 * @PostMapping("/products/{productcode}") public Products
	 * createProduct(@RequestBody Products newProduct) { return
	 * productsJpaRepository.save(newProduct); }
	 */

	@DeleteMapping("/products/{productcode}")
	public String deleteProduct(@PathVariable String productcode) {
		productsJpaRepository.deleteById(productcode);
		return "Delete Product" + " " + productcode + " " + "Success";
	}
}
