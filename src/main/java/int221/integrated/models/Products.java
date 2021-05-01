package int221.integrated.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String productCode;
	private String productName;
	private String productDescription;
	private double price;
	private String saleDate;
    //private List<Picture> pictures;
	public Products() {
	}

	public Products(String productCode, String productname, String productdescription, double price, String saleDate) {
		this.productCode = productCode;
		this.productName = productname;
		this.productDescription = productdescription;
		this.price = price;
		this.saleDate = saleDate;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductname() {
		return productName;
	}

	public void setProductname(String productname) {
		this.productName = productname;
	}

	public String getProductdescription() {
		return productDescription;
	}

	public void setProductdescription(String productdescription) {
		this.productDescription = productdescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getsaleDate() {
		return saleDate;
	}

	public void setsaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	
}
