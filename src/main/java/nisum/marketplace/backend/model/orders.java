package nisum.marketplace.backend.model;

import java.util.Optional;

import javax.persistence.*;


@Table(name = "orders")
@Entity

public class orders {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name = "order_id")    
    private int order_id;

    @Column(name = "user_id")    
    private int user_id;

    @Column(name = "address_id")    
    private int address_id;

    @Column(name = "price")    
    private float price;

    @Column(name = "credit_card_id")    
    private int credit_card_id;

    @Column(name = "date_ordered")    
    private String date_ordered;

    @Column(name = "date_shipped")    
    private String date_shipped;

    //@Column(name = "date_delivered")    
    //private String date_delivered;

    @Column(name = "order_status")    
    private String order_status;

    public String getDateOrdered() {
        return date_ordered;
    }
    public void setDateOrdered(String date_ordered) {
        this.date_ordered = date_ordered;
    }
    public int getOrderID() {
        return order_id;
    }
    public void setOrderID(int order_id) {
        this.order_id = order_id;
    }
    public int getUserId() {
        return user_id;
    }
    public void setUserId(int user_id) {
        this.user_id = user_id;
    }
    public int getAddressID() {
        return address_id;
    }
    public void setAddressID(int address_id) {
        this.address_id = address_id;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getCreditCardID() {
        return credit_card_id;
    }
    public void setCreditCardID(int credit_card_id) {
        this.credit_card_id = credit_card_id;
    }
    public String getOrderStatus() {
        return order_status;
    }
    public void setOrderStatus(String order_status) {
        this.order_status = order_status;
    }
    public String getDateShipped() {
        return date_shipped;
    }
    public void setDateShipped(String date_shipped) {
        this.date_shipped = date_shipped;
    }
    //public String getDateDelivered() {
    //    return date_delivered;
    //}
    //public void setDateDelivered(String date_delivered) {
    //    this.date_delivered = date_delivered;
    //}
    @Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user_id=" + user_id + ", address_id=" + address_id + ", price="
				+ price + ", credit_card_id=" + credit_card_id + ", date_ordered=" + date_ordered + ", date_shipped="
				+ date_shipped + ", order_status=" + order_status + "]";
	}
}