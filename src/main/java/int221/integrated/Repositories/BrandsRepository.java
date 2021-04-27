package int221.integrated.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import int221.integrated.models.Brands;

public interface BrandsRepository extends JpaRepository<Brands, String> {

}
