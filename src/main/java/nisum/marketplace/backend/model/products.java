package nisum.marketplace.backend.model;

import java.util.Optional;

import javax.persistence.*;


@Table(name = "products")
@Entity

public class products {
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Id
    @Column(name = "upc")    
    private String upc;

    public String getUPC(){
        return upc;
    }

    public void setUPC(String upc){
        this.upc = upc;
    }    

    @Column(name = "prod_name")  
    private String prod_name;

    public String getProdName(){
        return prod_name;
    }

    public void setProdName(String prod_name){
        this.prod_name = prod_name;
    }    

    @Column(name = "brand")  
    private String brand;

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }    
  
    @Column(name = "prod_description")  
    private String prod_description;

    public String getProdDesc(){
        return prod_description;
    }

    public void setProdDesc(String prod_description){
        this.prod_description = prod_description;
    }    

    @Column(name = "category")  
    private String category;

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }    

    @Column(name = "price_per_unit")  
    private float price_per_unit;

    public float getPPU(){
        return price_per_unit;
    }

    public void setPPU(float price_per_unit){
        this.price_per_unit = price_per_unit;
    }    

    @Column(name = "image_url")  
    private String image_url;

    public String getImgUrl(){
        return image_url;
    }

    public void setImgUrl(String image_url){
        this.image_url = image_url;
    }    

    @Column(name = "available_stock")  
    private int available_stock;

    public int getAS(){
        return available_stock;
    }

    public void setAS(int available_stock){
        this.available_stock = available_stock;
    }  

    @Column(name = "reserved_stock")  
    private int reserved_stock;

    public int getRS(){
        return reserved_stock;
    }

    public void setRS(int reserved_stock){
        this.reserved_stock = reserved_stock;
    }    

    @Column(name = "shipped_stock")  
    private int shipped_stock;

    public int getSS(){
        return shipped_stock;
    }

    public void setSS(int shipped_stock){
        this.shipped_stock = shipped_stock;
    }    

    @Override
	public String toString() {
		return "products [upc=" + upc + ", prod_name=" + prod_name + ", brand=" + brand + ", prod_description="
				+ prod_description + ", category=" + category + ", price_per_unit=" + price_per_unit + ", image_url="
				+ image_url + ", available_stock=" + available_stock + ", reserved_stock=" + reserved_stock+ ", shipped_stock="+ shipped_stock+"]"; 
	}
    
}
