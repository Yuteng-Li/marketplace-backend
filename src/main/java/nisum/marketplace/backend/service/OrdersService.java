package nisum.marketplace.backend.service;

import nisum.marketplace.backend.model.orders;

import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;

public interface OrdersService {
    List<orders> getOrdersUserId(int id);
    List<orders> getOrders();
    public boolean updateOrder(int id, String status);
}
