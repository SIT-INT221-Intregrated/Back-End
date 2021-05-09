package int221.integrated.RestControllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TestRestController {
	@GetMapping(path = "/test")
	public String health() {
		return "Test Server ^_^";
	}
}
