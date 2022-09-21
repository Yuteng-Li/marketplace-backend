package nisum.marketplace.backend;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nisum.marketplace.backend.model.CartItems;
import nisum.marketplace.backend.service.CartItemsService;

@CrossOrigin
/*localhost:8080/api/marketplace/(the mapping I defined)*/
@RequestMapping("/api/marketplace")
@RestController
public class CartItemsController {
	
	@Autowired
	CartItemsService cartService;
	
	/*
	 * No requestbody and path variable needed
	 * */
	@GetMapping("/getcart")
	public ResponseEntity<Object> getCart(){
		try {
			List<CartItems> cartList = cartService.getCart();
			//return Ok and the body with cartList
			return ResponseEntity.status(HttpStatus.OK).body(cartList);
		}
		
		catch(Exception e) {
			//when getCart method fail.
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail to getall");
		}
	}
	
	/*
	 * pass in an Id from the url path.
	 * */
	@GetMapping("/getcart/{id}")
	public ResponseEntity<Object> getCartById(@PathVariable Integer id){
		try {
			
			Optional<CartItems> result = cartService.findCartById(id);
			//when we have a cart by ID
			if(result.isPresent()) {
				return ResponseEntity.status(HttpStatus.OK).body(result);
			}
			//When we do not have a cart by ID
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID do not exist");
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID do not exist");
		}
	}
	
	/*
	 * Request body needed.
	 * */
	@PostMapping("/createcart")
	public ResponseEntity<Object> createCart(@RequestBody CartItems cartItems){
		try {
			CartItems result = cartService.createSale(cartItems);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}
		//when we fail to create cart
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail to create");
		}
	}
	
	
	@PutMapping("/updatecart")
	public ResponseEntity<Object> updateCart(@RequestBody CartItems cartItems){
		try {
			//this is basically the same as createCart method
			CartItems result = cartService.updateCart(cartItems);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}
		catch(Exception e) {
			//when updateCart fail
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("update fail");
		}
	}
	
	
	/*
	 * delete a cart via ID, if it doesnt exist, throw an exception
	 * 
	 * */
	@DeleteMapping("/deletecart/{id}")
	public ResponseEntity<Object> deleteCart(@PathVariable Integer id){
		
		try {
			//if delete is success
			Boolean flag = cartService.deleteById(id);
			String deleteStatus = "detele id: " + id+ " is" +flag;
			return ResponseEntity.status(HttpStatus.OK).body(deleteStatus);
		}
		//when we fail to delete
		catch(Exception e) {
			Boolean flag = false;
			String deleteStatus = "detele id: " + id+ " is" +flag;
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(deleteStatus);
		}
	}
	
}
