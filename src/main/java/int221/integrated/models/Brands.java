package int221.integrated.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
public class Brands {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brandid")
	private String brandid;

	@OneToMany(mappedBy = "brands_brandid")
	Set<Products> products;

	@Column(name = "brandname")
	private String brandname;

	public Brands() {
	}

	public Brands(String brandid, String brandname) {
		this.brandid = brandid;
		this.brandname = brandname;
	}

	public String getBrandid() {
		return brandid;
	}

	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
}
