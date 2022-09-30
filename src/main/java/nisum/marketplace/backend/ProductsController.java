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
import nisum.marketplace.backend.model.products;
import nisum.marketplace.backend.service.OrderItemsService;
import nisum.marketplace.backend.service.OrdersService;
import nisum.marketplace.backend.service.ProductsService;

// get this from Inventory backend

@RequestMapping("api/products")
@RestController
@CrossOrigin
public class ProductsController {
    
    
    @Autowired
    ProductsService orderService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){return "Hello from Controller; orders";}


    @GetMapping("/getProducts")
    public ResponseEntity<List<products>> getProducts(){
        List<products> orders = orderService.getProducts();
        for (products k: orders){System.out.println(k);}
        if (orders.size() > 0){
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("get/{upc}")
    public ResponseEntity<List<products>> getProductsId(@PathVariable("upc") String upc) {
        List<products> orders=orderService.getProductsId(upc);
        if(orders.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }
    
}