package mentoring.productProject.repository;

import mentoring.productProject.resource.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {


}
