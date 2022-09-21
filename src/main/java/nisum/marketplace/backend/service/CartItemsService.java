package nisum.marketplace.backend.service;


import java.util.List;
import java.util.Optional;

import nisum.marketplace.backend.model.CartItems;

public interface CartItemsService {
	public List<CartItems> getCart();
	public CartItems updateCart(CartItems cartItems);
	public Boolean deleteById(Integer id);
	public Optional<CartItems> findCartById(Integer id);
	public CartItems createSale(CartItems cartItems);
	
}
