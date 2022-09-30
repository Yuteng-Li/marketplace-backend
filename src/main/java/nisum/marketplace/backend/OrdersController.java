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

import nisum.marketplace.backend.model.orders;
import nisum.marketplace.backend.service.OrdersService;


// Get this from OMS backend

@RequestMapping("api/order")
@RestController
@CrossOrigin
public class OrdersController {
    
    
    @Autowired
    OrdersService orderService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){return "Hello from Controller; orders";}


    @GetMapping("/getOrders")
    public ResponseEntity<List<orders>> getOrders(){
        List<orders> orders = orderService.getOrders();
        for (orders k: orders){System.out.println(k);}
        if (orders.size() > 0){
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/getOrders/user/{id}")
    public ResponseEntity<List<orders>> getOrderInfo(@PathVariable("id") int id) {
        List<orders> orders=orderService.getOrdersUserId(id);
        if(orders.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @PutMapping("/updateOrder/cancelled/{id}")
    public ResponseEntity<String> cancelledOrder(@PathVariable("id") int id){
        boolean success = orderService.updateOrder(id, "Cancelled");
        if (success) {
            return ResponseEntity.status(HttpStatus.OK).body(id + " Cancelled successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    
}