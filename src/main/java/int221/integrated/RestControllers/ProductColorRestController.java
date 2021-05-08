package int221.integrated.RestControllers;

import int221.integrated.Repositories.ProductColorsJpaRepository;
import int221.integrated.Repositories.ProductsJpaRepository;
import int221.integrated.models.Productcolors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController // คลาสนี้เป็น Controller ของ API

public class ProductColorRestController {
	
	@Autowired
	private ProductsJpaRepository productsJpaRepository;
	
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
    
    @PostMapping("/addProductColors")
    public String addProductColors(@RequestBody List<Productcolors> newColors) {
    	for (int i = 0; i < newColors.size(); i++) {
    		int lastId = Integer.parseInt(productColorsJpaRepository.findAll().get((int) productColorsJpaRepository.count()-1).getProductcolorsid().substring(2));
        	int newIntId = lastId+1;
        	String newProductColorCode = "PC"+(newIntId);
        	newColors.get(i).setProductcode(productsJpaRepository.findAll().get((int) productsJpaRepository.count()-1).getProductcode());
        	newColors.get(i).setProductcolorsid(newProductColorCode);
        	productColorsJpaRepository.save(newColors.get(i));
		}
		return "Add Product Color Complete";
    }
    
    @PutMapping("/updateColor/{productcode}")
    public String updateColors(@PathVariable String productcode, @RequestBody List<Productcolors> newColors) {
    	String[] targetProductColorId = new String[10];
    	for (int i = 0; i < productColorsJpaRepository.count(); i++) {
        	if(productColorsJpaRepository.findAll().get(i).getProductcode().equalsIgnoreCase(productcode)) {
        		for (int j = 0; j < targetProductColorId.length; j++) {
					if(targetProductColorId[j]==null) {
						targetProductColorId[j] = productColorsJpaRepository.findAll().get(i).getProductcolorsid();
						break;
					}
				}
        	}
    	}
        for (int i = 0; i < targetProductColorId.length; i++) {
        	if(targetProductColorId[i] != null) {
        		productColorsJpaRepository.deleteById(targetProductColorId[i]);
        	}
		}
    	 
    	for (int i = 0; i < newColors.size(); i++) {
    		int lastId = Integer.parseInt(productColorsJpaRepository.findAll().get((int) productColorsJpaRepository.count()-1).getProductcolorsid().substring(2));
        	int newIntId = lastId+1;
        	String newProductColorCode = "PC"+(newIntId);
        	newColors.get(i).setProductcode(productcode);
        	newColors.get(i).setProductcolorsid(newProductColorCode);
        	productColorsJpaRepository.save(newColors.get(i));
    	}
			
    	return "update product color : "+productcode; 
    } 
  

}
