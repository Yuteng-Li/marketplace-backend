package nisum.marketplace.backend.repository;

import nisum.marketplace.backend.model.orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<orders, Integer> {
}
