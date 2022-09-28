package nisum.marketplace.backend.repository;

import nisum.marketplace.backend.model.orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<orders, Integer> {

}
