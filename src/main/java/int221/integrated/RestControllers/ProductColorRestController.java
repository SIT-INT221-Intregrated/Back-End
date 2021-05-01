package int221.integrated.RestControllers;

import int221.integrated.Repositories.ProductColorsJpaRepository;
import int221.integrated.models.Colors;
import int221.integrated.models.Productcolors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:80" })
@RestController // คลาสนี้เป็น Controller ของ API

public class ProductColorRestController {
    @Autowired
    private ProductColorsJpaRepository productColorsJpaRepository;

    @GetMapping("/productcolors")
    public List<Productcolors> showAllProductsColors(){
        return productColorsJpaRepository.findAll();
    }
    @GetMapping("/productcolors/{productcolors_id}")
    public Productcolors showProductsColor(@PathVariable String productcolors_id) {
        Productcolors productsColor = this.productColorsJpaRepository.findById(productcolors_id).orElse(null);
        return productsColor;
    }
    /*@PostMapping("/productcolors")
    public Colors createProductsColors(@RequestBody Productcolors newProductcolor) {
        return productColorsJpaRepository.save(newProductcolor);
    }*/

}
