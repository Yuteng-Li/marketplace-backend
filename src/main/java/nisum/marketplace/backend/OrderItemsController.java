package nisum.marketplace.backend;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import nisum.marketplace.backend.model.OrderItems;
import nisum.marketplace.backend.service.OrderItemsService;
import nisum.marketplace.backend.service.OrdersService;

// Get this from OMS backend


@RequestMapping("api/order/items")
@RestController
@CrossOrigin
public class OrderItemsController {
    
    
    @Autowired
    OrderItemsService orderService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){return "Hello from Controller; orders";}


    @GetMapping("/getOrderItems")
    public ResponseEntity<List<OrderItems>> getOrderItems(){
        List<OrderItems> orders = orderService.getOrderItems();
        for (OrderItems k: orders){System.out.println(k);}
        if (orders.size() > 0){
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getOrderInfo/{id}")
    public ResponseEntity<List<OrderItems>> getOrderItemsInfo(@PathVariable("id") int id) {
        List<OrderItems> orders=orderService.getOrderItemsUser(id);
        if(orders.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }
    
}