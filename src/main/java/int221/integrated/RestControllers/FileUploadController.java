package int221.integrated.RestControllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import int221.integrated.Repositories.ProductColorsJpaRepository;
import int221.integrated.Repositories.ProductsJpaRepository;
import int221.integrated.models.Productcolors;
import int221.integrated.models.Products;
import int221.integrated.service.StorageService;
import int221.integrated.Exception.*;

@CrossOrigin
@RestController
public class FileUploadController {

	@Autowired
	ProductsJpaRepository productsJpaRepository;

	@Autowired
	private ProductColorsJpaRepository productColorsJpaRepository;

	final StorageService storageService;

	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
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

	@PostMapping(value = "/addProductColors")
	public String create(@RequestBody List<Productcolors> newColors) {
		for (int i = 0; i < newColors.size(); i++) {
			int lastColorsId = Integer.parseInt(productsJpaRepository.findAll()
					.get((int) productsJpaRepository.count() - 1).getProductcode().substring(1));
			int newlastColorsId = lastColorsId + 1;
			String newProductColorsId = "pc" + (newlastColorsId);
			newColors.get(i).setProduct_productcode(
					productsJpaRepository.findAll().get((int) productsJpaRepository.count() - 1).getProductcode());
			newColors.get(i).setProductcolors_id(newProductColorsId);
			productColorsJpaRepository.save(newColors.get(i));

		}
		return "Add Product Color Complete";
	}
	
	@PutMapping(value = "/UpdateProducts")
	public String UpdateProducts() {
		return null;
		
	}
	
	@PutMapping(value = "/UpdateColors")
	public String UpdateColors() {
		return null;
		
	}
	
	@PutMapping(value = "/UpdateImages")
	public String UpdateImages() {
		return null;
		
	}
	

	@GetMapping(value = "/Files/{filename:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
	public Resource serveFile(@PathVariable String filename) {
		return storageService.loadAsResource(filename);
	}

	@DeleteMapping(value = "/DeleteFile/{filename:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void deleteFile(@PathVariable String filename) throws IOException {
		storageService.delete(filename);
	}

	@PostMapping("/UploadImage")
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {
		storageService.store(file);
		return "Upload complete";
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
