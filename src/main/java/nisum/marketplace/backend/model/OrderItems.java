package nisum.marketplace.backend.model;

import java.util.Optional;

import javax.persistence.*;


@Table(name = "order_items")
@Entity

public class OrderItems {
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Id
    @Column(name = "order_item_id")    
    private int order_item_id;

    @Column(name = "order_id")    
    private int order_id;

    @Column(name = "quantity")    
    private int quantity;

    @Column(name = "upc")    
    private String upc;

    public int getOrderItemID() {
        return order_item_id;
    }
    public void setOrderItemID(int order_item_id) {
        this.order_item_id = order_item_id;
    }
    public int getOrderID() {
        return order_id;
    }
    public void setOrderID(int order_id) {
        this.order_id = order_id;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }
    public String getUpc() {
        return upc;
    }
    public void setUpc(String upc) {
        this.upc = upc;
    }

    @Override
	public String toString() {
		return "Order [order_item_id="+ order_item_id + ", order_id=" + order_id + ", quantity=" + quantity + ", upc=" + upc + "]"; /*", street=" + street+ ", card_number="+ card_number+"]"; */
	}
}