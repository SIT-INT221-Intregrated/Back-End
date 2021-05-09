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

	@GetMapping(value = "/Files/{filename:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
	public Resource serveFile(@PathVariable String filename) {
		return storageService.loadAsResource(filename);
	}
		
	/*@GetMapping(value = "/Filestest/{filename:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
	public Resource serveFiletest(@PathVariable String filename) {
		Resource image =   (Resource) this.storageService.load(filename);     //storageService.loadAsResource(filename);
		if (image == null) {
			throw new ProductException(ExceptionResponse.ERROR_CODE.IMAGES_NAME_ALREADY_EXIST,
					"Can not Find this Images Because Image Id : " + filename + " does not exist.");
			//return image;
		}
		return storageService.loadAsResource(filename);
	}*/

	@PostMapping("/uploadImage")
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {
		storageService.store(file);
		return "Upload complete";
	}
	
	@PutMapping("/updateimage/{productcode}")
    public String handleFileUpdate(@PathVariable String productcode,@RequestParam("file") MultipartFile file) throws IOException {
    	String oldImage = productsJpaRepository.findById(productcode).get().getImages();
    	storageService.delete(productsJpaRepository.findById(productcode).get().getImages());
        storageService.store(file);
        	return "Update complete: Change "+oldImage+ " to "+file.getOriginalFilename();
    }

	@DeleteMapping(value = "/deleteFile/{filename:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void deleteFile(@PathVariable String filename) throws IOException {
		storageService.delete(filename);
	}
	
	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
