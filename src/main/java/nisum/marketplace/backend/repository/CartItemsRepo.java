package nisum.marketplace.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nisum.marketplace.backend.model.CartItems;

@Repository
public interface CartItemsRepo extends JpaRepository<CartItems,Integer>{

}
