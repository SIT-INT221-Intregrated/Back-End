package int221.integrated.RestControllers;

import int221.integrated.Repositories.ColorsJpaRepository;
import int221.integrated.models.Colors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController // คลาสนี้เป็น Controller ของ API
public class ColorRestController {
    @Autowired
    private ColorsJpaRepository colorsJpaRepository;

    @GetMapping("/colors")
    public List<Colors> showAllcolors(){
        return colorsJpaRepository.findAll();
    }
    @GetMapping("/colors/{colorId}")
    public Colors showColor(@PathVariable String colorId) {
        Colors color = this.colorsJpaRepository.findById(colorId).orElse(null);
        return color;
    }
    @PostMapping("/colors")
    public Colors createColor(@RequestBody Colors newColor) {
        return colorsJpaRepository.save(newColor);
    }

}
