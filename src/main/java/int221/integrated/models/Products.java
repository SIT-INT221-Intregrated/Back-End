package int221.integrated.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "Products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String productCode;
	private String productName;
	private String productDescription;
	private double Price;
	private String manufactureDate;
	private String BrandsBrandId;

	public Products(String productCode, String productname, String productdescription, double price,
			String manufactureDate) {
		super();
		this.productCode = productCode;
		this.productName = productname;
		this.productDescription = productdescription;
		this.Price = price;
		this.manufactureDate = manufactureDate;
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
		return Price;
	}

	public void setPrice(double price) {
		this.Price = price;
	}

	public String getManufacturedate() {
		return manufactureDate;
	}

	public void setManufacturedate(String manufacturedate) {
		this.manufactureDate = manufacturedate;
	}
}
