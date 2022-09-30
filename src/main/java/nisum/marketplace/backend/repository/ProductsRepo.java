package nisum.marketplace.backend.repository;

import nisum.marketplace.backend.model.products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepo extends JpaRepository<products, Integer> {

}
