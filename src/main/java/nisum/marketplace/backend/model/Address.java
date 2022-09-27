package nisum.marketplace.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "addresses")
@Entity
public class Address {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer address_id;
	private Integer user_id;
	private String recipient_name;
	private String street;
	private String street2;
	private String city;
	private String state;
	private String zip;
	private Boolean is_shipping;
	private Boolean is_billing;
	
	public Address() {
		
	}

	public Address(Integer addressID, Integer userID, String recipientName, String street, String street2,
			String city, String state, String zip, Boolean isShipping, Boolean isBilling) {
		super();
		this.address_id = addressID;
		this.user_id = userID;
		this.recipient_name = recipientName;
		this.street = street;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.is_shipping = isShipping;
		this.is_billing = isBilling;
	}

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer addressID) {
		this.address_id = addressID;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer userID) {
		this.user_id = userID;
	}

	public String getRecipient_name() {
		return recipient_name;
	}

	public void setRecipient_name(String recipientName) {
		this.recipient_name = recipientName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Boolean getIs_shipping() {
		return is_shipping;
	}

	public void setIs_shipping(Boolean isShipping) {
		this.is_shipping = isShipping;
	}

	public Boolean getIs_billing() {
		return is_billing;
	}

	public void setIs_billing(Boolean isBilling) {
		this.is_billing = isBilling;
	}
	
	
	
}
