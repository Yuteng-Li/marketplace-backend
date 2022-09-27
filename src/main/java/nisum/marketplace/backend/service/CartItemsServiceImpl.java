package nisum.marketplace.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nisum.marketplace.backend.model.CartItems;
import nisum.marketplace.backend.repository.CartItemsRepo;

@Service
public class CartItemsServiceImpl implements CartItemsService {

	@Autowired
	CartItemsRepo cartRepo;
	
	/*
	 * handle update by just creating an item if it doesnt exit
	 * 
	 * */
	@Override
	public CartItems updateCart(Integer cartID,CartItems cartItems) throws Exception{
		if (!cartRepo.existsById(cartItems.getCart_item_id())) {
            System.out.println("Cart could not be updated. Cart does not exists.");
            throw new Exception();
        } else {
            return cartRepo.save(cartItems);
        }
	}
	
	/*
	 * return everything in database
	 * */
	@Override
	public List<CartItems> getCart() {
		return cartRepo.findAll();
	}

	/*
	 * delete if the id exist, handle exception in controller.
	 * the id should be pass from pathvariable
	 * */
	@Override
	public Boolean deleteById(Integer id) {
		//if the id exist
		if (cartRepo.findById(id) != null) {
			//delete such id and return true
			cartRepo.deleteById(id);
			return true;
		}
		
		//when id do not exist
		return false;
	}
	
	/*
	 * if id do not exist, handle it from the controller
	 * */
	@Override
	public CartItems findCartById(Integer id) throws Exception{
		if (cartRepo.findById(id).isEmpty()) {
			System.out.println("cart with id:" + id + "could not be found");
			throw new Exception();
		}
		else {
			return cartRepo.findById(id).get();
		}
	}
	
	/*
	 * just create an cart by using .save
	 * */
	@Override
	public CartItems createSale(CartItems cartItems) {
		return cartRepo.save(cartItems);
	}
	
}
