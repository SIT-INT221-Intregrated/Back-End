package int221.integrated.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping({ "/api/create" }) // ในส่วนของ New นั้นจะมี 2 Mapping Create(Form จาก FE)/ Save
	public String create(Model model) {
		return "create";
	}

	@GetMapping({ "/api/save" })
	public String save(Products product, Model model) {
		this.productsRepository.save(product);
		model.addAttribute("product", product);
		return "redirect:/show/" + product.getProductCode(); // return เเบบ redirect เพื่อ show อันที่เราใส่เข้าไปใหม่
		// return "product";
	}

	@DeleteMapping({ "/api/delete" })
	public String delete(@RequestParam String productCode, Model model) {
		this.productsRepository.deleteById(productCode);
		return "redirect:/product";
	}

	@GetMapping({ "/api/edit/{productCode}" })
	public String edit(@PathVariable String productCode, Model model) {
		model.addAttribute("product", this.productsRepository.findById(productCode).orElse(null));
		return "edit";
	}
	@PutMapping({ "/api/update" })
	public String update(@RequestParam String productCode, @RequestParam String productname,
						 @RequestParam String productdescription, @RequestParam double price, @RequestParam String saleDate) {
		Products product = (Products) this.productsRepository.findById(productCode).orElse(null);
		product.setProductname(productname);
		product.setProductdescription(productdescription);
		product.setPrice(price);
		product.setsaleDate(saleDate);
		this.productsRepository.save(product);
		return "redirect:/show/" + product.getProductCode();
	}

}
