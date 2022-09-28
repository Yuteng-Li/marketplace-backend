package nisum.marketplace.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Addresses")
@Entity
public class Address {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name = "address_id")  
	private Integer addressID;
	@Column(name = "user_id")    
	private Integer userID;
	@Column(name = "recipient_name")    
	private String recipientName;
	private String street;
	private String street2;
	private String city;
	private String state;
	private String zip;
	@Column(name = "is_shipping")    
	private Boolean isShipping;
	@Column(name = "is_billing")    
	private Boolean isBilling;
	
	public Address() {
		
	}

	public Address(Integer addressID, Integer userID, String recipientName, String street, String street2,
			String city, String state, String zip, Boolean isShipping, Boolean isBilling) {
		super();
		this.addressID = addressID;
		this.userID = userID;
		this.recipientName = recipientName;
		this.street = street;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.isShipping = isShipping;
		this.isBilling = isBilling;
	}

	public Integer getAddressID() {
		return addressID;
	}

	public void setAddressID(Integer addressID) {
		this.addressID = addressID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
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

	public Boolean getIsShipping() {
		return isShipping;
	}

	public void setIsShipping(Boolean isShipping) {
		this.isShipping = isShipping;
	}

	public Boolean getIsBilling() {
		return isBilling;
	}

	public void setIsBilling(Boolean isBilling) {
		this.isBilling = isBilling;
	}


	@Override
	public String toString() {
		return "address [add-id=" + addressID + ", user_id=" + userID + ", rec_name=" + recipientName + ", street="
				+ street + ", street2=" + street2 + ", city=" + city + ", state="
				+ state + ", zip=" + zip + ", isShipping=" + isShipping+ ", isBilling="+ isBilling+"]"; 
	}
	
	
	
}
