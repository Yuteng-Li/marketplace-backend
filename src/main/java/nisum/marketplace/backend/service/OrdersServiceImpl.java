package nisum.marketplace.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nisum.marketplace.backend.model.orders;
import nisum.marketplace.backend.repository.OrdersRepository;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersRepository repo;

    @Override
    public List<orders> getOrders() {
        return repo.findAll();
    }

    @Override
    public List<orders> getOrdersUserId(int id) {
        List<orders> orders = new ArrayList<orders>();
        List<orders> exist = repo.findAll();
        if(exist.isEmpty()){
            return exist;
        }else{
            for(orders order:exist){
                if(order.getUserId()==id){
                    orders.add(order);
                }
            }
        }
        return orders;
    }
    
}