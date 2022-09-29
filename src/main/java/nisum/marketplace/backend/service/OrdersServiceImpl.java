package nisum.marketplace.backend.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        //return repo.findAllOrders();
    }

    @Override
    public List<orders> getOrdersUserId(int id) {
        List<orders> orders = new ArrayList<orders>();
        //List<orders> exist = repo.findAllOrders();
        List<orders> exist = repo.findAll();
        if(exist.isEmpty()){
            return exist;
        }else{
            for(orders order:exist){
                if(order.getUserId()==(id)){
                    orders.add(order);
                }
            }
        }
        return orders;
    }

    @Override
    public boolean updateOrder(int id, String status) {
        Optional<orders> exists = repo.findById(id);
        if (exists.isPresent()) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            switch (status) {
                case "Ordered":
                    if (exists.get().getOrderStatus().equals("Pending")){
                        exists.get().setDateOrdered(dtf.format(now));
                        exists.get().setOrderStatus(status);
                        repo.save(exists.get());
                        return true;
                    }
                    return false;

                case "Shipped":
                    if (exists.get().getOrderStatus().equals("Pending")) {
                        exists.get().setDateShipped(dtf.format(now));
                        exists.get().setOrderStatus(status);
                        repo.save(exists.get());
                        return true;
                    }
                    return false;
                    
                case "Cancelled":
                    if (exists.get().getOrderStatus().equals("Pending")) {
                        exists.get().setOrderStatus(status);
                        repo.save(exists.get());
                        return true;
                    }
                    return false;

                default:
                    return false;
            }
        }
        return false;
    }



    
}