
package nisum.marketplace.backend.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nisum.marketplace.backend.model.OrderItems;
import nisum.marketplace.backend.repository.OrderItemsRepo;
import nisum.marketplace.backend.repository.OrdersRepository;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {
    @Autowired
    OrderItemsRepo repo;

    @Override
    public List<OrderItems> getOrderItems() {
        return repo.findAll();
        //return repo.findAllOrders();
    }

    @Override
    public List<OrderItems> getOrderItemsUser(int id) {
        List<OrderItems> orders = new ArrayList<OrderItems>();
        //List<orders> exist = repo.findAllOrders();
        List<OrderItems> exist = repo.findAll();
        if(exist.isEmpty()){
            return exist;
        }else{
            for(OrderItems order:exist){
                if(order.getOrderID()==(id)){
                    orders.add(order);
                }
            }
        }
        return orders;
    }



    
}