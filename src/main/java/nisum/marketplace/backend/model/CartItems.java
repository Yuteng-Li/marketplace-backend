package nisum.marketplace.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="cart_items")
@Entity
public class CartItems {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer cart_item_id;
	Integer user_id;
	String upc;
	Integer quantity;
	public Integer getCart_item_id() {
		return cart_item_id;
	}
	public void setCart_item_id(Integer cart_item_id) {
		this.cart_item_id = cart_item_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartItems [cart_item_id=" + cart_item_id + ", user_id=" + user_id + ", upc=" + upc + ", quantity="
				+ quantity + "]";
	}
	public CartItems(Integer cart_item_id, Integer user_id, String upc, Integer quantity) {
		super();
		this.cart_item_id = cart_item_id;
		this.user_id = user_id;
		this.upc = upc;
		this.quantity = quantity;
	}
	public CartItems() {

	}
	
	
}
