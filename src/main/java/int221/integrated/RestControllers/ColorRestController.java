package int221.integrated.RestControllers;

import int221.integrated.Repositories.ColorsJpaRepository;
import int221.integrated.models.Colors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class ColorRestController {

	@Autowired
	private ColorsJpaRepository colorsJpaRepository;

	@GetMapping("/colors")
	public List<Colors> showAllcolors() {
		return colorsJpaRepository.findAll();
	}

	@GetMapping("/colors/{colorid}")
	public Colors showColor(@PathVariable String colorid) {
		Colors color = this.colorsJpaRepository.findById(colorid).orElse(null);
		return color;
	}
}
