package int221.integrated.models;

import java.sql.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	@Id
	@Column(name = "productcode")
	private String productcode;

	@Column(name = "productname")
	private String productname;

	@Column(name = "productdescription")
	private String productdescription;

	@Column(name = "price")
	private double price;

	@Column(name = "saledate")
	private java.sql.Date saledate;

	@Column(name = "brands_brandid")
	private String brands_brandid;

	@Column(name = "images")
	private String images;

	@ManyToOne
	@JoinColumn(name = "brands_brandid", insertable = false, updatable = false)
	Brands brands;

	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Productcolors> productcolors;

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public java.sql.Date getSaledate() {
		return saledate;
	}

	public void setSaledate(java.sql.Date saledate) {
		this.saledate = saledate;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getBrands_brandid() {
		return brands_brandid;
	}

	public void setBrands_brandid(String brands_brandid) {
		this.brands_brandid = brands_brandid;
	}

	public Set<Productcolors> getProductcolors() {
		return productcolors;
	}

	public void setProductcolors(Set<Productcolors> productcolors) {
		this.productcolors = productcolors;
	}
}