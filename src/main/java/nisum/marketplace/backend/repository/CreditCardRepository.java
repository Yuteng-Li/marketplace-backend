package nisum.marketplace.backend.repository;

import nisum.marketplace.backend.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Integer>{
}
