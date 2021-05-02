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

	@GetMapping("/products/{productCode}")
	public Products showProduct(@PathVariable String productCode) {
		Products product = this.productsJpaRepository.findById(productCode).orElse(null);
		return product;
	}

	@PostMapping("/products")
	public Products createProduct(@RequestBody Products newProduct) {
		return productsJpaRepository.save(newProduct);
	}

	@DeleteMapping("/product/{productCode}")
	public String deleteProduct(@PathVariable String productCode) {
		productsJpaRepository.deleteById(productCode);
		return "delete product success";
	}

	/*
	 * @PostMapping("/create") public Products createProduct(@RequestBody Products
	 * newProduct) { return productsJpaRepository.save(newProduct); }
	 * 
	 * @RequestMapping("/create") public String create(Model model) { return
	 * "create"; }
	 * 
	 * @GetMapping("/save") public String save(@RequestBody Products newProduct) {
	 * productsJpaRepository.save(newProduct); // newProduct.("product",
	 * newProduct); return "redirect:/show/" + newProduct.getProductCode(); }
	 */

}
