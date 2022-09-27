package nisum.marketplace.backend.repository;

import nisum.marketplace.backend.model.orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<orders, Integer> {
    //@Query(value = "SELECT * FROM orders",
    //@Query(value = "SELECT DISTINCT o.user_id, o.order_id, a.street, o.price, cc.card_number,o.date_ordered, o.date_shipped, o.order_status FROM orders o JOIN Addresses a ON o.address_id = a.address_id JOIN credit_cards cc WHERE o.credit_card_id = cc.credit_card_id",
    @Query(value = "SELECT DISTINCT * FROM orders o JOIN Addresses a ON o.address_id = a.address_id JOIN credit_cards cc WHERE o.credit_card_id = cc.credit_card_id",
    nativeQuery = true)
    List<orders> findAllOrders();
}
