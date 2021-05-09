package int221.integrated.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import int221.integrated.models.Products;

public interface ProductsJpaRepository extends JpaRepository<Products, String> {

}