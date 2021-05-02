package int221.integrated.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
public class Brands {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brandid")
	private String brandId;
	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name = "brands_brandid", nullable = false)
	 */

	@Column(name = "brandname")
	private String brandName;

	public Brands() {
	}

	public Brands(String brandid, String brandname) {
		this.brandId = brandid;
		this.brandName = brandname;
	}

	public String getBrandid() {
		return brandId;
	}

	public void setBrandid(String brandid) {
		this.brandId = brandid;
	}

	public String getBrandname() {
		return brandName;
	}

	public void setBrandname(String brandname) {
		this.brandName = brandname;
	}
}
