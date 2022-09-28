package nisum.marketplace.backend.service;


import java.util.List;

import nisum.marketplace.backend.model.CartItems;

public interface CartItemsService {
	public List<CartItems> getCart();
	public CartItems updateCart(Integer id,CartItems cartItems) throws Exception;
	public Boolean deleteById(Integer id);
	public CartItems findCartById(Integer id) throws Exception;
	public CartItems createSale(CartItems cartItems);
	
}
