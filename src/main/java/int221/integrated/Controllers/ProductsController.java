package int221.integrated.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import int221.integrated.Repositories.ProductsRepository;
import int221.integrated.models.Products;

@Controller
public class ProductsController {
	@Autowired
	private ProductsRepository productsRepository; // สิ่งที่ใช้งานบ่อยๆคือ object ของ productRepository ต้อง find
													// หาเเละเอามาใช้

	public ProductsController() {
	}

	@RequestMapping({ "/product" }) // เรียก Products ทั้งหมดมาให้
	public String product(Model model) {
		model.addAttribute("products", this.productsRepository.findAll());
		return "product";
	}

	@RequestMapping({ "/show/{productCode}" }) // หลังจากเรียก products มาเป็น list
												// เเล้วต้องกาารดึงข้อมูลมาโชว์รายละเอียด
	public String show(@PathVariable String productCode, Model model) {
		model.addAttribute("product", this.productsRepository.findById(productCode).orElse(null));
		return "show";
	}

	@RequestMapping({ "/create" }) // ในส่วนของ New นั้นจะมี 2 Mapping Create(Form จาก FE)/ Save
	public String create(Model model) {
		return "create";
	}

	@RequestMapping({ "/save" })
	public String save(Products product, Model model) {
		this.productsRepository.save(product);
		model.addAttribute("product", product);
		return "redirect:/show/" + product.getProductCode(); // return เเบบ redirect เพื่อ show อันที่เราใส่เข้าไปใหม่
		// return "product";
	}

	@RequestMapping({ "/delete" })
	public String delete(@RequestParam String productCode, Model model) {
		this.productsRepository.deleteById(productCode);
		return "redirect:/product";
	}

	@RequestMapping({ "/edit/{productCode}" })
	public String edit(@PathVariable String productCode, Model model) {
		model.addAttribute("product", this.productsRepository.findById(productCode).orElse(null));
		return "edit";
	}

	@RequestMapping({ "/update" })
	public String update(@RequestParam String productCode, @RequestParam String productname,
			@RequestParam String productdescription, @RequestParam double price, @RequestParam String manufactureDate) {
		Products product = (Products) this.productsRepository.findById(productCode).orElse(null);
		product.setProductname(productname);
		product.setProductdescription(productdescription);
		product.setPrice(price);
		product.setManufacturedate(manufactureDate);
		this.productsRepository.save(product);
		return "redirect:/show/" + product.getProductCode();
	}
}
