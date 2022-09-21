package nisum.marketplace.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="cartitems")
@Entity
public class CartItems {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cartitemid")
	Integer cartItemID;
	@Column(name="userid")
	Integer userID;
	@Column(name="upc")
	String UPC;
	@Column(name="quantity")
	Integer quantity;
	
	public Integer getCartItemID() {
		return cartItemID;
	}
	public void setCartItemID(Integer cartItemID) {
		this.cartItemID = cartItemID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUPC() {
		return UPC;
	}
	public void setUPC(String uPC) {
		UPC = uPC;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public CartItems(Integer cartItemID, Integer userID, String uPC, Integer quantity) {
		super();
		this.cartItemID = cartItemID;
		this.userID = userID;
		UPC = uPC;
		this.quantity = quantity;
	}

	public CartItems(){};
	
	
	
	
}
