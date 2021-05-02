package int221.integrated.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productcode")
	private String productCode;

	@Column(name = "productname")
	private String productName;

	@Column(name = "productdescription")
	private String productDescription;

	@Column(name = "price")
	private double price;

	@Column(name = "saledate")
	private String saleDate;
	// private List<Picture> pictures;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "brandId", nullable = false) private Brands
	 * brands_brandid;
	 * 
	 * 
	 * @ManyToMany(fetch=FetchType.LAZY)
	 * 
	 * @JoinTable(name="productcode"
	 */
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
