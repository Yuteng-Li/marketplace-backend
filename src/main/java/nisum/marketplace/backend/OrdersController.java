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


@RequestMapping("api/orders")
@RestController
@CrossOrigin
public class OrdersController {
    
    @Autowired
    OrdersService orderService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){return "Hello from Controller; orders";}

    /**
     * This method gets all orders in the database and displays it
     * @return a list with all orders in our database. If there is nothing
     * in the database, it returns no content as the http status
     */
    @GetMapping("/getOrders")
    public ResponseEntity<List<orders>> getOrders(){
        List<orders> orders = orderService.getOrders();
        for (orders k: orders){System.out.println(k);}
        if (orders.size() > 0){
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * This method gets list of order from a particular user
     * @param id the id of the user
     * @return a list of orders that the user has made
     */
    @GetMapping("/getOrders/user/{id}")
    public ResponseEntity<List<orders>> getOrderInfo(@PathVariable("id") int id) {
        List<orders> orders=orderService.getOrdersUserId(id);
        if(orders.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }
}