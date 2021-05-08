package int221.integrated.RestControllers;

import int221.integrated.Repositories.ProductsJpaRepository;
import int221.integrated.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
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

	@PostMapping(value = "/addProducts")
	public String create(@RequestBody Products newProducts) {
		int lastCode = Integer.parseInt(productsJpaRepository.findAll().get((int) productsJpaRepository.count() - 1)
				.getProductcode().substring(1));
		int newLastCode = lastCode + 1;
		String newProductCode = "p" + (newLastCode);
		newProducts.setProductcode(newProductCode);
		productsJpaRepository.save(newProducts);
		return "uplode Product";
	}

	@PutMapping("/updateProduct")
	public Products updateProduct(@RequestBody Products newProducts) {
		Products editProduct = productsJpaRepository.findById(newProducts.getProductcode()).orElse(null);
		if (editProduct != null) {
			editProduct.setProductname(newProducts.getProductname());
			editProduct.setProductdescription(newProducts.getProductdescription());
			editProduct.setImages(newProducts.getImages());
			editProduct.setPrice(newProducts.getPrice());
			editProduct.setSaledate(newProducts.getSaledate());
			editProduct.setBrands_brandid(newProducts.getBrands_brandid());
			productsJpaRepository.save(editProduct);
		}
		return editProduct;
	}

	@DeleteMapping("/products/{productcode}")
	public String deleteProduct(@PathVariable String productcode) {
		productsJpaRepository.deleteById(productcode);
		return "delete product success";
	}
}
