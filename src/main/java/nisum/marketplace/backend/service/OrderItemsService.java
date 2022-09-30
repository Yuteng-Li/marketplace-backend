package nisum.marketplace.backend.service;

import nisum.marketplace.backend.model.OrderItems;

import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;

public interface OrderItemsService {
    List<OrderItems> getOrderItemsUser(int id);
    List<OrderItems> getOrderItems();

}
