package int221.integrated.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import int221.integrated.Repositories.BrandsJpaRepository;
import int221.integrated.models.Brands;

@CrossOrigin
@RestController // คลาสนี้เป็น Controller ของ API

public class BrandRestController {
	@Autowired
	private BrandsJpaRepository brandsjpaRepository;

	@GetMapping("/brands")
	public List<Brands> showAllBrands() {
		return brandsjpaRepository.findAll();
	}

	@GetMapping("/brands/{brandId}")
	public Brands showBrand(@PathVariable String brandId) {
		Brands brand = this.brandsjpaRepository.findById(brandId).orElse(null);
		return brand;
	}
}
