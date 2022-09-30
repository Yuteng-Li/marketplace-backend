
package nisum.marketplace.backend.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nisum.marketplace.backend.model.products;
import nisum.marketplace.backend.repository.ProductsRepo;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    ProductsRepo repo;

    @Override
    public List<products> getProducts() {
        return repo.findAll();
        //return repo.findAllOrders();
    }

    @Override
    public List<products> getProductsId(String id) {
        List<products> orders = new ArrayList<products>();
        //List<orders> exist = repo.findAllOrders();
        List<products> exist = repo.findAll();
        if(exist.isEmpty()){
            return exist;
        }else{
            for(products order:exist){
                if(Objects.equals(order.getUPC(), (id))){
                    orders.add(order);
                }
            }
        }
        return orders;
    }



    
}