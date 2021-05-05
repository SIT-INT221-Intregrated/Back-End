package int221.integrated.RestControllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import int221.integrated.Exception.StorageFileNotFoundException;
import int221.integrated.Repositories.ProductsJpaRepository;
import int221.integrated.service.StorageService;

@RestController
public class FileUploadController {

	@Autowired
	ProductsJpaRepository productsJpaRepository;

//	@Autowired
//    private ProductColorsJpaRepository productColorsJpaRepository;

	final StorageService storageService;

	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}

//	@GetMapping("/")
//	public String listUploadedFiles() throws IOException {
//		storageService.loadAll()
//				.map(path -> MvcUriComponentsBuilder
//						.fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString()).build()
//						.toUri().toString())
//				.collect(Collectors.toList());
//		return "uploadForm";
//	}

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
		return "Uplode complete";
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

//	@PostMapping(value = "/upload")
//    public String create(@RequestBody Products newProducts, @RequestBody Productcolors newProductColors) {
//    	productsJpaRepository.save(newProducts);
//    	productColorsJpaRepository.save(newProductColors);
//		return "uplode Product" + newProducts.getProductCode() + " "
//			+ newProducts.getProductname() + " "
//			+ newProducts.getProductdescription() + " "
//			+ newProducts.getPrice() + " "
//			+ newProducts.getsaleDate() + " "
//			+ newProducts.getImages() + " "
//
//			;
//    }

}
