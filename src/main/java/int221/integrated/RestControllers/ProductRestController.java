package int221.integrated.RestControllers;

import int221.integrated.Exception.ProductException;
import int221.integrated.Repositories.ProductsJpaRepository;
import int221.integrated.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import int221.integrated.Exception.ExceptionResponse;

@CrossOrigin
@RestController
public class ProductRestController {

	@Autowired
	private ProductsJpaRepository productsJpaRepository;

	@GetMapping("/products")
	public List<Products> showAllProducts() {
		return productsJpaRepository.findAll();
	}

	@GetMapping("/products/{productcode}")
	public Products showProducttest(@PathVariable String productcode) {
		Products product = this.productsJpaRepository.findById(productcode).orElse(null);
		if (product == null) {
			throw new ProductException(ExceptionResponse.ERROR_CODE.PRODUCT_DOES_NOT_EXIST,
					"Can not Find this Product Because Product Id : " + productcode + " does not exist.");
		}
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
		return "Add Product Complete";
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
	public String delete(@PathVariable String productcode) {
		Products product = productsJpaRepository.findById(productcode).orElse(null);
		if (product == null) {
			throw new ProductException(ExceptionResponse.ERROR_CODE.PRODUCT_DOES_NOT_EXIST,
					"Can not Delete this Product. Id : " + productcode + " does not exist.");
		}
		productsJpaRepository.deleteById(productcode);
		return "Delete Product Success";
	}
}
